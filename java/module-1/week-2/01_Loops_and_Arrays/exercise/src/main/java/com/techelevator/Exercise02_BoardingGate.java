package com.techelevator;

public class Exercise02_BoardingGate {

    /*
    Local Jetways is a regional airline operating at local airports.
    They use a basic passenger manifest to represent seat occupancy on their plane.
        Each passenger seat is represented as an element in a boolean array.
        A value of AVAILABLE (true) indicates that seat is currently available.
        A value of OCCUPIED (false) indicates the seat is not available.
     */
    private final boolean AVAILABLE = true;
    private final boolean OCCUPIED = false;

    /*
    A nearby airport has an incoming flight from Local Jetways. As the passengers disembark, the gate
    attendant's first responsibility is to generate a new seating chart with each seat initially available.

    Implement the logic to generate a seating chart using the required number of seats. Make sure to indicate
    that each seat is initially AVAILABLE (true).

    Note: The number of seats is guaranteed not to be negative.

    Examples:
    generateSeatingChart(7) → [AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE]
    generateSeatingChart(5) → [AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE]
    generateSeatingChart(2) → [AVAILABLE, AVAILABLE]
     */
    public boolean[] generateSeatingChart(int numberOfSeats) {
        // create the array called seatingchart that hold all booleans
        boolean[] seatingChart;
        // here we initalized the array to the no of seats
        seatingChart = new boolean[numberOfSeats];

        // for each seats make the seats available in the seating chart
        for (int i = 0; i < numberOfSeats; i++)
        // make the current seat available
        {
            seatingChart[i] = AVAILABLE;
        }
        // return the seating chart array out of the method.

        return seatingChart;
    }

    /*
    Once passengers begin boarding the plane, gate attendants need a way to determine how many available
    seats there are on the plane.

    Using the array provided, implement the logic to count the number of available seats in the seating chart.

    Examples:
    getAvailableSeatCount([AVAILABLE, OCCUPIED, OCCUPIED, OCCUPIED]) → 1
    which is the same as:
    getAvailableSeatCount([true, false, false, false]) → 1

    getAvailableSeatCount([OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED, OCCUPIED]) → 0
    getAvailableSeatCount([AVAILABLE, AVAILABLE, AVAILABLE, OCCUPIED]) → 3
    getAvailableSeatCount([]) → 0
     */
    public int getAvailableSeatCount(boolean[] seatingChart) {

        //this will keep  track of the seats
        int availableSeatCount = 0;
// for loop use to go through each seats
        for (int i = 0; i < seatingChart.length; i++) {

            //inside this loop we check if current seats i is available and if yes increment ++ to keep track
            if (seatingChart[i] == AVAILABLE) {
                availableSeatCount++;

            }

        }
// finally return availableseatcount so we know the count of avaialable seats.
        return availableSeatCount;
    }

    /*
    The crew determined that it would be nice to know how many rows on the plane are at full occupancy.
    Each row has three seats and a row is at full occupancy if all three seats have someone sitting in them.

    Using the boolean array, implement the logic to count the number of full rows on the plane.
    Note: A new row starts at every third element. For example, row one begins with index 0, row two begins with index 3, and so on.

    Examples:
    getNumberOfFullRows([OCCUPIED, OCCUPIED, OCCUPIED, AVAILABLE, AVAILABLE, AVAILABLE]) → 1
    getNumberOfFullRows([AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE, AVAILABLE]) → 0
    getNumberOfFullRows([OCCUPIED, AVAILABLE, AVAILABLE, OCCUPIED, AVAILABLE, AVAILABLE]) → 0
     */
    public int getNumberOfFullRows(boolean[] seatingChart) {
        int numberOfSeatsPerRow = 3;
        int fullRowCount = 0;
        int rowOccupancyCount = 0;

        for (int i = 0; i < seatingChart.length; i++) {
            if (!seatingChart[i]) {
                rowOccupancyCount++;
            }
            if ((i + 1) % numberOfSeatsPerRow == 0) {
                if (rowOccupancyCount == numberOfSeatsPerRow) {
                    fullRowCount++;
                }
                rowOccupancyCount = 0;
            }
        }
        return fullRowCount;
    }


}




