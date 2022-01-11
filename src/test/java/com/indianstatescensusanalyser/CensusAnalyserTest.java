package com.indianstatescensusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// UC2-Ability for the analyser to load the Indian States Code Information from a csv file

public class CensusAnalyserTest {

    private static final String INDIA_STATE_CODE_CSV = "./src/test/resources/IndianStateCode.csv";
    private static final String WRONG_STATE_CODE_CSV_PATH = "./src/main/resources/IndianStateCode.csv";
    private static final String STATE_CODE_INCORRECT_FILE_FORMAT = "./src/test/resources/IndianStateCode.txt";
    private static final String STATE_CODES_WITH_WRONG_DELIMITER = "./src/test/resources/IndianStateCodesWrongDelimiter.csv";
    private static final String STATE_CODES_WITH_INCORRECT_HEADER = "./src/test/resources/IndianStateCodesIncorrectHeader.csv";


    @Test
    public void givenIndiaStateCodeCSVFile_WhenCorrectPath_ShouldReturnsCorrectRecords()
    {
        try
        {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndianStateCode(INDIA_STATE_CODE_CSV);
            Assert.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenWithWrongFilePath_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(WRONG_STATE_CODE_CSV_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(STATE_CODE_INCORRECT_FILE_FORMAT);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCSVFile_WhenCustomDelimiter_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(STATE_CODES_WITH_WRONG_DELIMITER);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenIncorrectHeader_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(STATE_CODES_WITH_INCORRECT_HEADER);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        }
    }
}
