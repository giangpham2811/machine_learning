
public class batch {
    static double size[] = new double[]{30, 43, 25, 51, 40, 20};
    static double no_floors[] =new double[] {3, 4, 2, 4, 3, 1};
    static double no_rooms[] = new double[] {6, 8, 3, 9, 5, 2};
    static double price[] = new double[]{2.5, 3.4, 1.8, 4.5, 3.2, 1.6};
    static double theta[] = new double[];
    double learning_rate = 0.01;
    public static double cal_derivative(double x_values[][], double y_values[],double thetas[], int pos){
        double sigma = 0;
        for (int i = 0; i < y_values.length ; i++) {
            double sum = 0;
            for (int j = 0; j < ; j++) {
                sum += thetas[j]*x_values[j][i];
            }
            sum -= y_values[i];
            sigma = sigma +x_values[pos][i];
        }
        return sigma/y_values.length;
    }
    public static void main(String[] args) {

    }
}