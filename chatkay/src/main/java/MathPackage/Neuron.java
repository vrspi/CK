package MathPackage;
public class Neuron {
    public double[] weights;
    public double bias;
    public double output;

    public Neuron(int numInputs) {
        weights = new double[numInputs];
        // Initialize weights and bias randomly
        for (int i = 0; i < numInputs; i++) {
            weights[i] = 2 * Math.random() - 1;
        }
        bias = 2 * Math.random() - 1;
    }
}
