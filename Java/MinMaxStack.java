import java.util.*;

class MinMaxStack {
    ArrayList<Integer> dynamicArray = new ArrayList<>();
    Integer minValue = null;
    Integer maxValue = null;

    public int peek() {
        return dynamicArray.get(dynamicArray.size() - 1);
    }

    public int pop() {
        int popValue = dynamicArray.remove(dynamicArray.size() - 1);

        if (popValue == minValue)
            calculateMinValue();
        if (popValue == maxValue)
            calculateMaxValue();

        return popValue;
    }

    public void push(Integer number) {
        if (minValue == null || number < minValue)
            minValue = number;
        if (maxValue == null || number > maxValue)
            maxValue = number;
        dynamicArray.add(number);
    }

    public int getMin() {
        return minValue;
    }

    public int getMax() {
        return maxValue;
    }

    public void calculateMinValue() {
        if (dynamicArray.size() == 0) {
            minValue = null;
            return;
        }

        minValue = dynamicArray.get(0);
        for (int value : dynamicArray) {
            if (minValue > value)
                minValue = value;
        }
    }

    public void calculateMaxValue() {
        if (dynamicArray.size() == 0) {
            maxValue = null;
            return;
        }

        maxValue = dynamicArray.get(0);
        for (int value : dynamicArray) {
            if (maxValue < value)
                maxValue = value;
        }
    }
}

class MinMaxStackOptimized {
    // value, minValue, maxValue
    ArrayList<List<Integer>> minMaxStack = new ArrayList<>();

    public int peek() {
        return minMaxStack.get(minMaxStack.size() - 1).get(0);
    }

    public int pop() {
        return minMaxStack.remove(minMaxStack.size() - 1).get(0);
    }

    public void push(Integer number) {
        List<Integer> newMinMaxNode = new ArrayList<>();

        if (minMaxStack.size() == 0) {
            // value, minValue, maxValue
            newMinMaxNode.add(number);
            newMinMaxNode.add(number);
            newMinMaxNode.add(number);

            minMaxStack.add(newMinMaxNode);
            return;
        }

        List<Integer> currentNode = minMaxStack.get(minMaxStack.size() - 1);
        int minValue = currentNode.get(1);
        int maxValue = currentNode.get(2);

        newMinMaxNode.add(number);
        if (minValue > number)
            newMinMaxNode.add(number);
        else
            newMinMaxNode.add(minValue);

        if (maxValue < number)
            newMinMaxNode.add(number);
        else
            newMinMaxNode.add(maxValue);

        minMaxStack.add(newMinMaxNode);
    }

    public int getMin() {
        return minMaxStack.get(minMaxStack.size() - 1).get(1);
    }

    public int getMax() {
        return minMaxStack.get(minMaxStack.size() - 1).get(2);
    }
}