package gfg.simple;

import java.nio.charset.MalformedInputException;

public class Knapsack {

    static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;

        System.out.println(maxDuffelBagValue(cakeTypes, capacity));
    }

    private static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {

        int[] maxValuesAtCapacities = new int[capacity + 1];

        for (int currentCapacity = 0; currentCapacity <= capacity; currentCapacity++) {

            int currentmax = 0;

            for (CakeType cakeType : cakeTypes) {

                if (cakeType.weight == 0 && cakeType.value != 0) {
                    try {
                        throw new MalformedInputException(cakeType.weight);
                    } catch (MalformedInputException e) {
                        e.printStackTrace();
                    }
                }

                if (cakeType.weight <= capacity) {
                    int maxValueUsingCake = cakeType.value + maxValuesAtCapacities[capacity - cakeType.weight];

                    currentmax = Math.max(maxValueUsingCake, currentmax);
                }

                maxValuesAtCapacities[currentCapacity] = currentmax;

            }

        }


        return maxValuesAtCapacities[capacity];
    }
}
