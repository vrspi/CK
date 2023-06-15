package MathPackage;

public class Main {
    
    public static double normalizeInput(double x) {
        // normalize input to range [-1, 1]
        return (x - (-100)) / (100 - (-100)) * 2 - 1;
    }
    
    public static double denormalizeOutput(double x) {
        // denormalize output from range [0, 1] to [0, 10000]
        return x * 10000;
    }

    public static double normalizeTarget(double x) {
        // normalize target to range [0, 1]
        return x / 10000;
    }

    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork(1, 10);

        // Train the neural network to approximate f(x) = x^2
        for (int i = 0; i < 10000000; i++) {
            // Random values in the range [-100, 100]
            double x = 200 * Math.random() - 100;
            double normalizedInput = normalizeInput(x);
            double target = x * x;
            double normalizedTarget = normalizeTarget(target);
            nn.train(new double[]{normalizedInput}, normalizedTarget);
        }

        // Test
        for (int i = -100; i <= 100; i+=5) {
            double x = i;
            double normalizedInput = normalizeInput(x);
            double neuralNetworkOutput = nn.forward(new double[]{normalizedInput});
            double denormalizedOutput = denormalizeOutput(neuralNetworkOutput);
            System.out.println("x = " + x + ", f(x) = " + (x * x) + ", nn(x) = " + denormalizedOutput);
        }
    }
}
