package org.cirdles.mars.scripps;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by johnzeringue on 12/21/15.
 */
public class CsvScrippsSampleSource implements ScrippsSampleSource {

    private final Path coreSampleCsv;
    private final Path coreIntervalCsv;

    public CsvScrippsSampleSource(Path coreSampleCsv, Path coreIntervalCsv) {
        this.coreSampleCsv = coreSampleCsv;
        this.coreIntervalCsv = coreIntervalCsv;
    }

    private static Reader readerFor(Path path) {
        try {
            return Files.newBufferedReader(path, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void verifyHeader(String actualHeader, String expectedHeader) {
        if (!Objects.equals(actualHeader, expectedHeader)) {
            throw new ScrippsException();
        }
    }

    private static void verifyCoreSampleHeaders(CSVReader csvReader) {
        try {
            String[] headers = csvReader.readNext();

            verifyHeader(headers[0], "FACILITY_CODE");
            verifyHeader(headers[1], "SHIP_CODE");
            verifyHeader(headers[2], "PLATFORM");
            verifyHeader(headers[3], "CRUISE");
            verifyHeader(headers[4], "SAMPLE");
            verifyHeader(headers[5], "DEVICE");
            verifyHeader(headers[6], "BEGIN_DATE");
            verifyHeader(headers[7], "END_DATE");
            verifyHeader(headers[8], "LAT");
            verifyHeader(headers[9], "END_LATMIN");
            verifyHeader(headers[10], "LON");
            verifyHeader(headers[11], "END_LON");
            verifyHeader(headers[12], "WATER_DEPTH");
            verifyHeader(headers[13], "END_WATER_DEPTH");
            verifyHeader(headers[14], "STORAGE_METH");
            verifyHeader(headers[15], "CORED_LENGTH");
            verifyHeader(headers[16], "CORED_LENGTH_MM");
            verifyHeader(headers[17], "CORED_DIAM");
            verifyHeader(headers[18], "CORED_DIAM_MM");
            verifyHeader(headers[19], "PI");
            verifyHeader(headers[20], "PROVINCE");
            verifyHeader(headers[21], "IGSN");
            verifyHeader(headers[22], "LEG");
            verifyHeader(headers[23], "SAMPLE_COMMENTS");
            verifyHeader(headers[24], "SHOW_SAMPL");
        } catch (IOException ex) {
            throw new ScrippsException(ex);
        }
    }

    private static void verifyCoreIntervalHeaders(CSVReader csvReader) {
        try {
            String[] headers = csvReader.readNext();

            verifyHeader(headers[0], "FACILITY_CODE");
            verifyHeader(headers[1], "SHIP_CODE");
            verifyHeader(headers[2], "PLATFORM");
            verifyHeader(headers[3], "CRUISE");
            verifyHeader(headers[4], "SAMPLE");
            verifyHeader(headers[5], "DEVICE");
            verifyHeader(headers[6], "INTERVAL");
            verifyHeader(headers[7], "DEPTH_TOP");
            verifyHeader(headers[8], "DEPTH_TOP_MM");
            verifyHeader(headers[9], "DEPTH_BOT");
            verifyHeader(headers[10], "DEPTH_BOT_MM");
            verifyHeader(headers[11], "LITH1");
            verifyHeader(headers[12], "TEXT1");
            verifyHeader(headers[13], "LITH2");
            verifyHeader(headers[14], "TEXT2");
            verifyHeader(headers[15], "COMP1");
            verifyHeader(headers[16], "COMP2");
            verifyHeader(headers[17], "COMP3");
            verifyHeader(headers[18], "COMP4");
            verifyHeader(headers[19], "COMP5");
            verifyHeader(headers[20], "COMP6");
            verifyHeader(headers[21], "DESCRIPTION");
            verifyHeader(headers[22], "AGE");
            verifyHeader(headers[23], "ABSOLUTE_AGE_TOP");
            verifyHeader(headers[24], "ABSOLUTE_AGE_BOT");
            verifyHeader(headers[25], "WEIGHT");
            verifyHeader(headers[26], "ROCK_LITH");
            verifyHeader(headers[27], "ROCK_MIN");
            verifyHeader(headers[28], "WEATH_META");
            verifyHeader(headers[29], "REMARK");
            verifyHeader(headers[30], "MUNSELL_CODE");
            verifyHeader(headers[31], "MUNSELL");
            verifyHeader(headers[32], "EXHAUST_CODE");
            verifyHeader(headers[33], "INT_COMMENTS");
            verifyHeader(headers[34], "IGSN");
        } catch (IOException ex) {
            throw new ScrippsException(ex);
        }
    }

    private static String valueOf(String csvValue) {
        String result = null;

        if (!csvValue.isEmpty()) {
            result = csvValue;
        }

        return result;
    }

    private static ScrippsSample readSample(
            CSVReader coreSampleCsvReader,
            CSVReader coreIntervalCsvReader) {
        ScrippsSample result = null;

        try {
            String[] coreSample = coreSampleCsvReader.readNext();
            String[] coreInterval = coreIntervalCsvReader.readNext();

            if (coreSample != null && coreInterval != null) {
                result = new ScrippsSample()
                        .setFacilityCode(coreSample[0])
                        .setShipCode(coreSample[1])
                        .setPlatform(coreSample[2])
                        .setCruise(coreSample[3])
                        .setSample(coreSample[4]);
            }
        } catch (IOException ex) {
            throw new ScrippsException(ex);
        }

        return result;
    }

    @Override
    public List<ScrippsSample> getScrippsSamples() {
        CSVReader coreSampleCsvReader = new CSVReader(readerFor(coreSampleCsv));
        CSVReader coreIntervalCsvReader = new CSVReader(readerFor(coreIntervalCsv));

        verifyCoreSampleHeaders(coreSampleCsvReader);
        verifyCoreIntervalHeaders(coreIntervalCsvReader);

        List<ScrippsSample> result = new ArrayList<>();

        ScrippsSample nextScrippsSample;
        while ((nextScrippsSample = readSample(coreSampleCsvReader, coreIntervalCsvReader)) != null) {
            result.add(nextScrippsSample);
        }

        return result;
    }

}
