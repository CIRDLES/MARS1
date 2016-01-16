package org.cirdles.mars.scripps;

import org.cirdles.mars.api.Sample;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by johnzeringue on 12/26/15.
 */
public class ScrippsSampleAdapter implements Sample {

    private String archive;
    private String platformName;
    private String cruiseName;
    private String name;
    private String collectionMethod;
    private LocalDate collectionBeginDate;
    private LocalDate collectionEndDate;
    private BigDecimal wgs84Latitude;
    private BigDecimal wgs84EndingLatitude;
    private BigDecimal wgs84Longitude;
    private BigDecimal wgs84EndingLongitude;
    private BigDecimal elevation;
    private BigDecimal endingElevation;
    private String material;
    private String type;

    public ScrippsSampleAdapter(ScrippsSample scrippsSample) {
        copyFields(scrippsSample);
    }

    private void copyFields(ScrippsSample scrippsSample) {
        // TODO map facility code to facility name
        archive = scrippsSample.getFacilityCode();

        platformName = scrippsSample.getPlatform();
        cruiseName = scrippsSample.getCruise();
        name = scrippsSample.getSample();
        collectionMethod = scrippsSample.getDevice();
        collectionBeginDate = null;
        collectionEndDate = null;
        wgs84Latitude = null;
        wgs84EndingLatitude = null;
        wgs84Longitude = null;
        wgs84EndingLongitude = null;
        elevation = null;
        endingElevation = null;
        material = null;
        type = null;
    }

    @Override
    public String getArchive() {
        return archive;
    }

    @Override
    public void setArchive(String archive) {
        this.archive = archive;
    }

    @Override
    public String getPlatformName() {
        return platformName;
    }

    @Override
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String getCruiseName() {
        return cruiseName;
    }

    @Override
    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCollectionMethod() {
        return collectionMethod;
    }

    @Override
    public void setCollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
    }

    @Override
    public LocalDate getCollectionBeginDate() {
        return collectionBeginDate;
    }

    @Override
    public void setCollectionBeginDate(LocalDate collectionBeginDate) {
        this.collectionBeginDate = collectionBeginDate;
    }

    @Override
    public LocalDate getCollectionEndDate() {
        return collectionEndDate;
    }

    @Override
    public void setCollectionEndDate(LocalDate collectionEndDate) {
        this.collectionEndDate = collectionEndDate;
    }

    @Override
    public BigDecimal getWgs84Latitude() {
        return wgs84Latitude;
    }

    @Override
    public void setWgs84Latitude(BigDecimal wgs84Latitude) {
        this.wgs84Latitude = wgs84Latitude;
    }

    @Override
    public BigDecimal getWgs84EndingLatitude() {
        return wgs84EndingLatitude;
    }

    @Override
    public void setWgs84EndingLatitude(BigDecimal wgs84EndingLatitude) {
        this.wgs84EndingLatitude = wgs84EndingLatitude;
    }

    @Override
    public BigDecimal getWgs84Longitude() {
        return wgs84Longitude;
    }

    @Override
    public void setWgs84Longitude(BigDecimal wgs84Longitude) {
        this.wgs84Longitude = wgs84Longitude;
    }

    @Override
    public BigDecimal getWgs84EndingLongitude() {
        return wgs84EndingLongitude;
    }

    @Override
    public void setWgs84EndingLongitude(BigDecimal wgs84EndingLongitude) {
        this.wgs84EndingLongitude = wgs84EndingLongitude;
    }

    @Override
    public BigDecimal getElevation() {
        return elevation;
    }

    @Override
    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    @Override
    public BigDecimal getEndingElevation() {
        return endingElevation;
    }

    @Override
    public void setEndingElevation(BigDecimal endingElevation) {
        this.endingElevation = endingElevation;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean isMutable() {
        return true;
    }
}
