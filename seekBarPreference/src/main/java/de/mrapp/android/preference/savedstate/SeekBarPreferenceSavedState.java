/*
 * AndroidSeekBarPreference Copyright 2014 Michael Rapp
 *
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>. 
 */
package de.mrapp.android.preference.savedstate;

import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference.BaseSavedState;

/**
 * A data structure, which allows to save the internal state of a
 * {@link SeekBarPreference}.
 * 
 * @author Michael Rapp
 * 
 * @since 1.0.0
 */
public class SeekBarPreferenceSavedState extends BaseSavedState {

	/**
	 * The saved value of the attribute "value".
	 */
	private float value;

	/**
	 * The saved value of the attribute "seekBarValue".
	 */
	private float seekBarValue;

	/**
	 * The saved value of the attribute "minValue".
	 */
	private int minValue;

	/**
	 * The saved value of the attribute "maxValue".
	 */
	private int maxValue;

	/**
	 * The saved value of the attribute "stepSize".
	 */
	private int stepSize;

	/**
	 * The saved value of the attribute "decimals".
	 */
	private int decimals;

	/**
	 * The saved value of the attribute "suffix".
	 */
	private String suffix;

	/**
	 * The saved value of the attribute "floatingPointSeparator".
	 */
	private String floatingPointSeparator;

	/**
	 * The saved value of the attribute "summaries".
	 */
	private String[] summaries;

	/**
	 * The saved value of the attribute "showValueAsSummary".
	 */
	private boolean showValueAsSummary;

	/**
	 * The saved value of the attribute "showProgress".
	 */
	private boolean showProgress;

	/**
	 * Creates a new data structure, which allows to store the internal state of
	 * a {@link SeekBarPreference}. This constructor is called by derived
	 * classes when saving their states.
	 * 
	 * @param superState
	 *            The state of the superclass of this view, as an instance of
	 *            the type {@link Parcelable}
	 */
	public SeekBarPreferenceSavedState(final Parcelable superState) {
		super(superState);
	}

	/**
	 * Creates a new data structure, which allows to store the internal state of
	 * a {@link SeekBarPreference}. This constructor is used when reading from a
	 * parcel. It reads the state of the superclass.
	 * 
	 * @param source
	 *            The parcel to read read from as a instance of the class
	 *            {@link Parcel}
	 */
	public SeekBarPreferenceSavedState(final Parcel source) {
		super(source);
		value = source.readFloat();
		seekBarValue = source.readFloat();
		minValue = source.readInt();
		maxValue = source.readInt();
		stepSize = source.readInt();
		decimals = source.readInt();
		suffix = source.readString();
		floatingPointSeparator = source.readString();
		showValueAsSummary = source.readByte() != 0;
		showProgress = source.readByte() != 0;
		summaries = source.createStringArray();
	}

	/**
	 * Returns the saved value of the attribute "value".
	 * 
	 * @return The saved value of the attribute "value" as a {@link Float} value
	 */
	public final float getValue() {
		return value;
	}

	/**
	 * Sets the saved value of the attribute "value".
	 * 
	 * @param value
	 *            The saved of the attribute "value", which should be set, as a
	 *            {@link Float} value
	 */
	public final void setValue(final float value) {
		this.value = value;
	}

	/**
	 * Returns the saved value of the attribute "seekBarValue".
	 * 
	 * @return The saved value of the attribute "seekBarValue" as a
	 *         {@link Float} value
	 */
	public final float getSeekBarValue() {
		return seekBarValue;
	}

	/**
	 * Sets the saved value of the attribute "seekBarValue".
	 * 
	 * @param seekBarValue
	 *            The saved value of the attribute "seekBarValue", which should
	 *            be set, as a {@link Float} value
	 */
	public final void setSeekBarValue(final float seekBarValue) {
		this.seekBarValue = seekBarValue;
	}

	/**
	 * Returns the saved value of the attribute "minValue".
	 * 
	 * @return The saved value of the attribute "minValue" as an {@link Integer}
	 *         value
	 */
	public final int getMinValue() {
		return minValue;
	}

	/**
	 * Sets the saved value of the attribute "minValue".
	 * 
	 * @param minValue
	 *            The saved value of the attribute "minValue", which should be
	 *            set, as an {@link Integer} value
	 */
	public final void setMinValue(final int minValue) {
		this.minValue = minValue;
	}

	/**
	 * Returns the saved value of the attribute "maxValue".
	 * 
	 * @return The saved value of the attribute "maxValue" as an {@link Integer}
	 *         value
	 */
	public final int getMaxValue() {
		return maxValue;
	}

	/**
	 * Sets the saved value of the attribute "maxValue".
	 * 
	 * @param maxValue
	 *            The saved value of the attribute "maxValue", which should be
	 *            set, as an {@link Integer} value
	 */
	public final void setMaxValue(final int maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * Returns the saved value of the attribute "stepSize".
	 * 
	 * @return The saved value of the attribute "stepSize" as an {@link Integer}
	 *         value
	 */
	public final int getStepSize() {
		return stepSize;
	}

	/**
	 * Sets the saved value of the attribute "stepSize".
	 * 
	 * @param stepSize
	 *            The saved value of the attribute "stepSize", which should be
	 *            set, as an {@link Integer} value
	 */
	public final void setStepSize(final int stepSize) {
		this.stepSize = stepSize;
	}

	/**
	 * Returns the saved value of the attribute "decimals".
	 * 
	 * @return The saved value of the attribute "decimals" as an {@link Integer}
	 *         value
	 */
	public final int getDecimals() {
		return decimals;
	}

	/**
	 * Sets the saved value of the attribute "decimals".
	 * 
	 * @param decimals
	 *            The saved value of the attribute "decimals", which should be
	 *            set, as an {@link Integer} value
	 */
	public final void setDecimals(final int decimals) {
		this.decimals = decimals;
	}

	/**
	 * Returns the saved value of the attribute "suffix".
	 * 
	 * @return The saved value of the attribute "suffix" as a {@link String}
	 */
	public final String getSuffix() {
		return suffix;
	}

	/**
	 * Sets the saved value of the attribute "suffix".
	 * 
	 * @param suffix
	 *            The saved value of the attribute "suffix", which should be
	 *            set, as a {@link String}
	 */
	public final void setSuffix(final String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Returns the saved value of the attribute "floatingPointSeparator".
	 * 
	 * @return The saved value of the attribute "floatingPointSeparator" as a
	 *         {@link String}
	 */
	public final String getFloatingPointSeparator() {
		return floatingPointSeparator;
	}

	/**
	 * Sets the saved value of the attribute "floatingPointSeparator".
	 * 
	 * @param floatingPointSeparator
	 *            The saved value of the attribute "floatingPointSeparator",
	 *            which should be set, as a {@link String}
	 */
	public final void setFloatingPointSeparator(
			final String floatingPointSeparator) {
		this.floatingPointSeparator = floatingPointSeparator;
	}

	/**
	 * Returns the saved value of the attribute "summaries".
	 * 
	 * @return The saved value of the attribute "summaries" as a {@link String}
	 *         array
	 */
	public final String[] getSummaries() {
		return summaries;
	}

	/**
	 * Sets the saved value of the attribute "summaries".
	 * 
	 * @param summaries
	 *            The saved value of the attribute "summaries", which should be
	 *            set, as a {@link String} array
	 */
	public final void setSummaries(final String[] summaries) {
		this.summaries = summaries;
	}

	/**
	 * Returns the saved value of the attribute "showValueAsSummary".
	 * 
	 * @return The saved value of the attribute "showValueAsSummary" as a
	 *         {@link Boolean} value
	 */
	public final boolean isValueShownAsSummary() {
		return showValueAsSummary;
	}

	/**
	 * Sets the saved value of the attribute "showValueAsSummary".
	 * 
	 * @param showValueAsSummary
	 *            The saved value of the attribute "showValueAsSummary", which
	 *            should be set, as a {@link Boolean} value
	 */
	public final void showValueAsSummary(final boolean showValueAsSummary) {
		this.showValueAsSummary = showValueAsSummary;
	}

	/**
	 * Returns the saved value of the attribute "showProgress".
	 * 
	 * @return The saved value of the attribute "showProgress" as a
	 *         {@link Boolean} value
	 */
	public final boolean isProgressShown() {
		return showProgress;
	}

	/**
	 * Sets the saved value of the attribute "showProgress".
	 * 
	 * @param showProgress
	 *            The saved value of the attribute "showProgress", which should
	 *            be set, as a {@link Boolean} value
	 */
	public final void showProgress(final boolean showProgress) {
		this.showProgress = showProgress;
	}

	@Override
	public final void writeToParcel(final Parcel destination, final int flags) {
		super.writeToParcel(destination, flags);
		destination.writeFloat(value);
		destination.writeFloat(seekBarValue);
		destination.writeInt(minValue);
		destination.writeInt(maxValue);
		destination.writeInt(stepSize);
		destination.writeInt(decimals);
		destination.writeString(suffix);
		destination.writeString(floatingPointSeparator);
		destination.writeByte((byte) (showValueAsSummary ? 1 : 0));
		destination.writeByte((byte) (showProgress ? 1 : 0));
		destination.writeStringArray(summaries);
	}

}