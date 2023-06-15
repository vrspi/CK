package MathPackage;

public class NeuralNetwork {
    private Neuron[] hiddenLayer;
    private Neuron outputNeuron;
    private double learningRate = 0.01;
    
    public NeuralNetwork(int numInputs, int numHidden) {
        hiddenLayer = new Neuron[numHidden];
        for (int i = 0; i < numHidden; i++) {
            hiddenLayer[i] = new Neuron(numInputs);
        }
        outputNeuron = new Neuron(numHidden);
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double sigmoidDerivative(double x) {
        return x * (1 - x);  // x is assumed to be sigmoid(x)
    }

    public double forward(double[] input) {
        double[] hiddenOutputs = new double[hiddenLayer.length];

        for (int i = 0; i < hiddenLayer.length; i++) {
            double sum = 0;
            for (int j = 0; j < hiddenLayer[i].weights.length; j++) {
                sum += hiddenLayer[i].weights[j] * input[j];
            }
            hiddenOutputs[i] = sigmoid(sum + hiddenLayer[i].bias);
            hiddenLayer[i].output = hiddenOutputs[i];
        }

        double outputSum = 0;
        for (int i = 0; i < hiddenOutputs.length; i++) {
            outputSum += outputNeuron.weights[i] * hiddenOutputs[i];
        }
        outputNeuron.output = sigmoid(outputSum + outputNeuron.bias);
        return outputNeuron.output;
    }

    public void train(double[] input, double target) {
        forward(input);

        double outputError = target - outputNeuron.output;
        double outputDelta = outputError * sigmoidDerivative(outputNeuron.output);

        double[] hiddenErrors = new double[hiddenLayer.length];
        double[] hiddenDeltas = new double[hiddenLayer.length];
        for (int i = 0; i < hiddenLayer.length; i++) {
            hiddenErrors[i] = outputNeuron.weights[i] * outputDelta;
            hiddenDeltas[i] = hiddenErrors[i] * sigmoidDerivative(hiddenLayer[i].output);
        }

        for (int i = 0; i < outputNeuron.weights.length; i++) {
            outputNeuron.weights[i] += learningRate * outputDelta * hiddenLayer[i].output;
        }
        outputNeuron.bias += learningRate * outputDelta;

        for (int i = 0; i < hiddenLayer.length; i++) {
            for (int j = 0; j < hiddenLayer[i].weights.length; j++) {
                hiddenLayer[i].weights[j] += learningRate * hiddenDeltas[i] * input[j];
            }
            hiddenLayer[i].bias += learningRate * hiddenDeltas[i];
        }
    }
}
