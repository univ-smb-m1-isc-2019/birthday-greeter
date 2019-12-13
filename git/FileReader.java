package com.company;

import java.util.Scanner;

class FileReader {
    public static Scanner Lire(String arg)  throws java.io.IOException {
        java.io.File myObj = new java.io.File(arg);
        return new Scanner(myObj);

    }
}
