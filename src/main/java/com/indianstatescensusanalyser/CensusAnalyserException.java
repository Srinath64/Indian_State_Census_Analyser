package com.indianstatescensusanalyser;

// UC1-Ability for the analyser to load the Indian States Census Information from a csv file

public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        CENSUS_FILE_PROBLEM, CENSUS_INCORRECT_FILE_FORMAT, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
