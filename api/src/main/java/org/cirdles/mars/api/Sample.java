package org.cirdles.mars.api;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by johnzeringue on 12/10/15.
 */
public interface Sample {

    /**
     * Returns the sample's archive.
     *
     * @return the archive
     */
    String getArchive();

    /**
     * Sets the sample's archive.
     *
     * @param archive the archive
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setArchive(String archive) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's platform name.
     *
     * @return the platform name
     */
    String getPlatformName();

    /**
     * Sets the sample's platform name.
     *
     * @param platformName the platform name
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setPlatformName(String platformName) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's cruise name.
     *
     * @return the cruise name
     */
    String getCruiseName();

    /**
     * Sets the sample's cruise name.
     *
     * @param cruiseName the cruise name
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setCruiseName(String cruiseName) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets the sample's name.
     *
     * @param name the name
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setName(String name) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's collection method.
     *
     * @return the collection method
     */
    String getCollectionMethod();

    /**
     * Sets the sample's collection method.
     *
     * @param collectionMethod the collection method
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setCollectionMethod(String collectionMethod) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the date on which sample collection begun.
     *
     * @return the collection begin date
     */
    LocalDate getCollectionBeginDate();

    /**
     * Sets the sample's collection begin date.
     *
     * @param collectionBeginDate the collection begin date
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setCollectionBeginDate(LocalDate collectionBeginDate) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the date on which sample collection ended.
     *
     * @return the collection end date
     */
    LocalDate getCollectionEndDate();

    /**
     * Sets the sample's collection end date.
     *
     * @param collectionEndDate the collection end date
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setCollectionEndDate(LocalDate collectionEndDate) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's latitude using the WGS 84 datum.
     *
     * @return the WGS 84 latitude
     */
    BigDecimal getWgs84Latitude();

    /**
     * Sets the sample's WGS84 latitude.
     *
     * @param collectionBeginDate the WGS84 latitude
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setWgs84Latitude(BigDecimal wgs84Latitude) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's ending latitude using the WGS 84 datum.
     *
     * @return the WGS 84 ending latitude
     */
    BigDecimal getWgs84EndingLatitude();

    /**
     * Sets the sample's WGS84 ending latitude.
     *
     * @param wgs84EndingLatitude the WGS 84 ending latitude
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setWgs84EndingLatitude(BigDecimal wgs84EndingLatitude) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's longitude using the WGS 84 datum.
     *
     * @return the WGS 84 longitude
     */
    BigDecimal getWgs84Longitude();

    /**
     * Sets the sample's WGS 84 longitude.
     *
     * @param wgs84Longitude the WGS 84 longitude
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setWgs84Longitude(BigDecimal wgs84Longitude) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's ending longitude using the WGS 84 datum.
     *
     * @return the WGS 84 ending longitude
     */
    BigDecimal getWgs84EndingLongitude();

    /**
     * Sets the sample's WGS 84 ending longitude.
     *
     * @param wgs84EndingLongitude the WGS 84 ending longitude
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setWgs84EndingLongitude(BigDecimal wgs84EndingLongitude) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's elevation in meters.
     *
     * @return the elevation in meters
     */
    BigDecimal getElevation();

    /**
     * Sets the sample's elevation.
     *
     * @param elevation the elevation
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setElevation(BigDecimal elevation) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's ending elevation in meters.
     *
     * @return the ending elevation in meters
     */
    BigDecimal getEndingElevation();

    /**
     * Sets the sample's ending elevation.
     *
     * @param endingElevation the ending elevation
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setEndingElevation(BigDecimal endingElevation) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's material.
     *
     * @return the material
     */
    String getMaterial();

    /**
     * Sets the sample's material.
     *
     * @param material the material
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setMaterial(String material) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sample's type.
     *
     * @return the type
     */
    String getType();

    /**
     * Sets the sample's type.
     *
     * @param type the type
     * @throws IllegalStateException         if {@link #isMutable()} returns
     *                                       {@code false}
     * @throws UnsupportedOperationException if mutability is not supported
     */
    default void setType(String type) {
        throw new UnsupportedOperationException();
    }

    default boolean isMutable() {
        return false;
    }

}
