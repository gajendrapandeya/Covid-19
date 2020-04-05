package com.codermonkeys.covid_19;

public class CasesItem {

    private String flagUrl;
    private String mCountryName;
    private int mTotalCases;
    private int mTodayCases;
    private int mTotalDeaths;
    private int mTodayDeaths;
    private int mRecovered;
    private int mActiveCases;

    public CasesItem(String flagUrl, String mCountryName, int mTotalCases, int mTodayCases, int mTotalDeaths, int mTodayDeaths, int mRecovered, int mActiveCases) {
        this.flagUrl = flagUrl;
        this.mCountryName = mCountryName;
        this.mTotalCases = mTotalCases;
        this.mTodayCases = mTodayCases;
        this.mTotalDeaths = mTotalDeaths;
        this.mTodayDeaths = mTodayDeaths;
        this.mRecovered = mRecovered;
        this.mActiveCases = mActiveCases;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public String getmCountryName() {
        return mCountryName;
    }

    public int getmTotalCases() {
        return mTotalCases;
    }

    public int getmTodayCases() {
        return mTodayCases;
    }

    public int getmTotalDeaths() {
        return mTotalDeaths;
    }

    public int getmTodayDeaths() {
        return mTodayDeaths;
    }

    public int getmRecovered() {
        return mRecovered;
    }

    public int getmActiveCases() {
        return mActiveCases;
    }
}
