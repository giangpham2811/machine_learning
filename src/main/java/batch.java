import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

import static java.lang.Math.pow;

public class batch {
    static List<Double> base;
    static List<Double> size;
    static List<Double> no_floors;
    static List<Double> no_rooms;
    static List<Double> prices;
    static List<List<Double>> x_values;
    static List<Double> thetas;
    public static double learning_rate = 0.001;
    public static double cal_derivative(List<List<Double>> x_values, List<Double> y_values, List<Double> thetas, int pos) {
        double sigma = 0;
        for (int i = 0; i < y_values.size(); i++) {
            double sum = 0;
            for (int j = 0; j < thetas.size() ; j++) {
                sum += thetas.get(j) * x_values.get(j).get(i);
            }
            sum -= y_values.get(i);
            sigma += sum * (x_values.get(pos).get(i));
        }
        return sigma/y_values.size();
    }
    public static List<Double> cal_next_theta(List<List<Double>> x_values, List<Double> y_values, List<Double> thetas, double learning_rate){
        List<Double> new_thetas = new ArrayList<Double>();
        for (int i = 0; i <thetas.size() ; i++) {
            double new_theta = thetas.get(i) - learning_rate * cal_derivative(x_values,y_values,thetas,i);
            new_thetas.add(new_theta);
        }
        return new_thetas;
    }
    public static double cal_cost(List<List<Double>> x_values, List<Double> y_values, List<Double> thetas){
        double sigma = 0;
        for (int i = 0; i <y_values.size() ; i++) {
            double sum= 0;
            for (int j = 0; j <thetas.size() ; j++) {
                sum += thetas.get(j) * x_values.get(j).get(i);
            }
            sum -= y_values.get(i);
            sigma += pow(sum,2);
        }
        return sigma / (2 * y_values.size());
    }
    public static void main(String[] args) {
       base = Arrays.asList(1.0,1.0,1.0,1.0,1.0,1.0);
       size = Arrays.asList(30.0, 43.0, 25.0, 51.0, 40.0, 20.0);
       no_floors = Arrays.asList(3.0, 4.0, 2.0, 4.0, 3.0, 1.0);
       no_rooms = Arrays.asList(6.0, 8.0, 3.0, 9.0, 5.0, 2.0);
       prices = Arrays.asList(2.5, 3.4, 1.8, 4.5, 3.2, 1.6);
       thetas = Arrays.asList(0.0,0.0,0.0,0.0);
       x_values = Arrays.asList(base,size,no_floors,no_rooms);
       List<Double> temp = thetas;
       double min_cost = cal_cost(x_values, prices, temp);
       List<Double> best_theta = thetas;
       for (int i = 0; i < 1000 ; i++) {
            temp = cal_next_theta(x_values,prices,thetas,learning_rate);
       }
       if (cal_cost(x_values,prices,temp)<min_cost){
           min_cost = cal_cost(x_values, prices, temp);
           best_theta = temp;
       }
       System.out.println(min_cost);
    }
}