/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.bitcode.stock_market;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.core.learning.SupervisedLearning;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;


/**
 *
 * @author DUSH
 */

public class NeuralNetworkStockPredictor {

	private int slidingWindowSize;
	private double max = 0;
	private double min = Double.MAX_VALUE;
	private String rawDataFilePath;
        private String learningDataFilePath;
	private String neuralNetworkModelFilePath;
        String[] values;

        private NeuralNetworkStockPredictor() {
    
        }
    
        
	public NeuralNetworkStockPredictor(int slidingWindowSize,String symbol,String[] val) {
		this.slidingWindowSize = slidingWindowSize;
                this.rawDataFilePath = "data/"+symbol+".csv";
                this.learningDataFilePath="data/"+symbol+"LearningData.csv";
                this.neuralNetworkModelFilePath="data/"+symbol+"stockPredictor.nnet";
                values=val;
	}

	void prepareData() throws IOException, URISyntaxException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(rawDataFilePath)));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
                            if(!line.equals("null")){
                                
				double crtValue = Double.valueOf(line);
				if (crtValue > max) {
					max = crtValue;
				}
				if (crtValue < min) {
					min = crtValue;
				}
                            }
                            
			}
		}
                catch(Exception ex){
                ex.printStackTrace();
                }
                finally {
			reader.close();
		}

		reader = new BufferedReader(new FileReader(new File(rawDataFilePath)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(learningDataFilePath)));

                LinkedList<Double> valuesQueue = new LinkedList<Double>();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
                            if(!line.equals("null")){
                                double crtValue = Double.valueOf(line);
				
				double normalizedValue = normalizeValue(crtValue);
				valuesQueue.add(normalizedValue);

				if (valuesQueue.size() == slidingWindowSize + 1) {
					String valueLine = valuesQueue.toString().replaceAll("\\[|\\]", "");
					writer.write(valueLine);
					writer.newLine();
					
					valuesQueue.removeFirst();
				}
                            }
				
			}
		}catch(Exception ex){
                ex.printStackTrace();
                }
                finally {
			reader.close();
			writer.close();
		}
	}

	double normalizeValue(double input) {
		return (input - min) / (max - min) * 0.8 + 0.1;
	}

	double deNormalizeValue(double input) {
		return min + (input - 0.1) * (max - min) / 0.8;
	}

	void trainNetwork() throws IOException {
		NeuralNetwork<BackPropagation> neuralNetwork = new MultiLayerPerceptron(slidingWindowSize, 2 * slidingWindowSize + 1, 1);

		int maxIterations = 1000;
		double learningRate = 0.5;
		double maxError = 0.00001;
		SupervisedLearning learningRule = neuralNetwork.getLearningRule();
		learningRule.setMaxError(maxError);
		learningRule.setLearningRate(learningRate);
		learningRule.setMaxIterations(maxIterations);
		learningRule.addListener(new LearningEventListener() {
			public void handleLearningEvent(LearningEvent learningEvent) {
				SupervisedLearning rule = (SupervisedLearning) learningEvent.getSource();
				
			}
		});

		DataSet trainingSet = loadTraininigData(learningDataFilePath);
		neuralNetwork.learn(trainingSet);
		neuralNetwork.save(neuralNetworkModelFilePath);
	}

	DataSet loadTraininigData(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		DataSet trainingSet = new DataSet(slidingWindowSize, 1);

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");

				double trainValues[] = new double[slidingWindowSize];
				for (int i = 0; i < slidingWindowSize; i++) {
					trainValues[i] = Double.valueOf(tokens[i]);
				}
				double expectedValue[] = new double[] { Double.valueOf(tokens[slidingWindowSize]) };
				trainingSet.addRow(new DataSetRow(trainValues, expectedValue));
			}
		}
                catch(Exception ex){
                ex.printStackTrace();
                }
                finally {
			reader.close();
		}
		return trainingSet;
	}

	double testNetwork() {
            double[] networkOutput = null;
            try {
		NeuralNetwork neuralNetwork = NeuralNetwork.createFromFile(neuralNetworkModelFilePath);
		neuralNetwork.setInput(normalizeValue(Double.parseDouble(values[4])),normalizeValue(Double.parseDouble(values[3])),
                        normalizeValue(Double.parseDouble(values[2])),normalizeValue(Double.parseDouble(values[1])), normalizeValue(Double.parseDouble(values[0])));

		neuralNetwork.calculate();
		networkOutput = neuralNetwork.getOutput();
                
                
                deleteFile(new File(rawDataFilePath));
                deleteFile(new File(learningDataFilePath));
                deleteFile(new File(neuralNetworkModelFilePath));
                
            } 
            catch (IOException ex) {
                Logger.getLogger(NeuralNetworkStockPredictor.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		return deNormalizeValue(networkOutput[0]);
	}
        
        private static void deleteFile(File file) throws IOException {
 
		if (!file.delete()) {
			throw new IOException();
		}
    }
}