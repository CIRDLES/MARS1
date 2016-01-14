package org.cirdles.mars.api;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by johnzeringue on 12/10/15.
 */
public interface Sample {

    /**
     * Returns the sample's platform name.
     *
     * @return the platform name
     */
    String getPlatformName();

    /**
     * Returns the sample's cruise name.
     *
     * @return the cruise name
     */
    String getCruiseName();

    /**
     * Returns the sample's name.
     *
     * @return the name
     */
    String getName();

    /**
     * Returns the date on which sample collection begun.
     *
     * @return the collection begin date
     */
    LocalDate getCollectionBeginDate();

    /**
     * Returns the date on which sample collection ended.
     *
     * @return the collection end date
     */
    LocalDate getCollectionEndDate();

    /**
     * Returns the sample's latitude using the WGS 84 datum.
     *
     * @return the WGS 84 latitude
     */
    BigDecimal getWgs84Latitude();

    /**
     * Returns the sample's ending latitude using the WGS 84 datum.
     *
     * @return the WGS 84 ending latitude
     */
    BigDecimal getWgs84EndingLatitude();

    /**
     * Returns the sample's longitude using the WGS 84 datum.
     *
     * @return the WGS 84 longitude
     */
    BigDecimal getWgs84Longitude();

    /**
     * Returns the sample's ending longitude using the WGS 84 datum.
     *
     * @return the WGS 84 ending longitude
     */
    BigDecimal getWgs84EndingLongitude();

    /**
     * Returns the sample's elevation in meters.
     *
     * @return the elevation in meters
     */
    BigDecimal getElevation();

    /**
     * Returns the sample's ending elevation in meters.
     *
     * @return the ending elevation in meters
     */
    BigDecimal getEndingElevation();

    /**
     * Returns the sample's material.
     *
     * @return the material
     */
    String getMaterial();

    /**
     * Returns the sample's type.
     *
     * @return the type
     */
    String getType();

}
