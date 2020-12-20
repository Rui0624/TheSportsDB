package example.com.thesportsdb.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "leagues")
public class League implements Parcelable {

    @PrimaryKey
    @NonNull
    private String idLeague;

    private String idSoccerXML;
    private String idAPIfootball;

    @ColumnInfo(name = "sport")
    private String strSport;

    @ColumnInfo(name = "league")
    private String strLeague;
    @ColumnInfo(name = "leagueAlternate")
    private String strLeagueAlternate;
    private String strDivision;
    private String idCup;
    private String strCurrentSeason;
    private String intFormedYear;
    private String dateFirstEvent;

    @ColumnInfo(name = "gender")
    private String strGender;

    @ColumnInfo(name = "country")
    private String strCountry;

    @ColumnInfo(name = "website")
    private String strWebsite;

    @ColumnInfo(name = "facebook")
    private String strFacebook;

    @ColumnInfo(name = "twitter")
    private String strTwitter;

    @ColumnInfo(name = "youtube")
    private String strYoutube;
    private String strRSS;

    @ColumnInfo(name = "description")
    private String strDescriptionEN;
    private String strDescriptionDE;
    private String strDescriptionFR;
    private String strDescriptionIT;
    private String strDescriptionCN;
    private String strDescriptionJP;
    private String strDescriptionRU;
    private String strDescriptionES;
    private String strDescriptionPT;
    private String strDescriptionSE;
    private String strDescriptionNL;
    private String strDescriptionHU;
    private String strDescriptionNO;
    private String strDescriptionPL;
    private String strDescriptionIL;
    private String strFanart1;
    private String strFanart2;
    private String strFanart3;
    private String strFanart4;
    private String strBanner;

    @ColumnInfo(name = "badge")
    private String strBadge;
    private String strLogo;
    private String strPoster;
    private String strTrophy;
    private String strNaming;
    private String strComplete;
    private String strLocked;


    public League(@NonNull String idLeague, String strSport, String strLeague,
                  String strGender, String strCountry, String strWebsite, String strFacebook,
                  String strTwitter, String strYoutube, String strDescriptionEN, String strBadge) {
        this.idLeague = idLeague;
        this.strSport = strSport;
        this.strLeague = strLeague;
        this.strGender = strGender;
        this.strCountry = strCountry;
        this.strWebsite = strWebsite;
        this.strFacebook = strFacebook;
        this.strTwitter = strTwitter;
        this.strYoutube = strYoutube;
        this.strDescriptionEN = strDescriptionEN;
        this.strBadge = strBadge;
    }


    protected League(Parcel in) {
        idLeague = in.readString();
        idSoccerXML = in.readString();
        idAPIfootball = in.readString();
        strSport = in.readString();
        strLeague = in.readString();
        strLeagueAlternate = in.readString();
        strDivision = in.readString();
        idCup = in.readString();
        strCurrentSeason = in.readString();
        intFormedYear = in.readString();
        dateFirstEvent = in.readString();
        strGender = in.readString();
        strCountry = in.readString();
        strWebsite = in.readString();
        strFacebook = in.readString();
        strTwitter = in.readString();
        strYoutube = in.readString();
        strRSS = in.readString();
        strDescriptionEN = in.readString();
        strDescriptionDE = in.readString();
        strDescriptionFR = in.readString();
        strDescriptionIT = in.readString();
        strDescriptionCN = in.readString();
        strDescriptionJP = in.readString();
        strDescriptionRU = in.readString();
        strDescriptionES = in.readString();
        strDescriptionPT = in.readString();
        strDescriptionSE = in.readString();
        strDescriptionNL = in.readString();
        strDescriptionHU = in.readString();
        strDescriptionNO = in.readString();
        strDescriptionPL = in.readString();
        strDescriptionIL = in.readString();
        strFanart1 = in.readString();
        strFanart2 = in.readString();
        strFanart3 = in.readString();
        strFanart4 = in.readString();
        strBanner = in.readString();
        strBadge = in.readString();
        strLogo = in.readString();
        strPoster = in.readString();
        strTrophy = in.readString();
        strNaming = in.readString();
        strComplete = in.readString();
        strLocked = in.readString();
    }

    public static final Creator<League> CREATOR = new Creator<League>() {
        @Override
        public League createFromParcel(Parcel in) {
            return new League( in );
        }

        @Override
        public League[] newArray(int size) {
            return new League[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( idLeague );
        parcel.writeString( strSport );
        parcel.writeString( strLeague );
        parcel.writeString( strGender );
        parcel.writeString( strCountry );
        parcel.writeString( strWebsite );
        parcel.writeString( strFacebook );
        parcel.writeString( strTwitter );
        parcel.writeString( strYoutube );
        parcel.writeString( strDescriptionEN );
        parcel.writeString( strBadge );
    }


    @NonNull
    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(@NonNull String idLeague) {
        this.idLeague = idLeague;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    public String getIdAPIfootball() {
        return idAPIfootball;
    }

    public void setIdAPIfootball(String idAPIfootball) {
        this.idAPIfootball = idAPIfootball;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public String getStrDivision() {
        return strDivision;
    }

    public void setStrDivision(String strDivision) {
        this.strDivision = strDivision;
    }

    public String getIdCup() {
        return idCup;
    }

    public void setIdCup(String idCup) {
        this.idCup = idCup;
    }

    public String getStrCurrentSeason() {
        return strCurrentSeason;
    }

    public void setStrCurrentSeason(String strCurrentSeason) {
        this.strCurrentSeason = strCurrentSeason;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getDateFirstEvent() {
        return dateFirstEvent;
    }

    public void setDateFirstEvent(String dateFirstEvent) {
        this.dateFirstEvent = dateFirstEvent;
    }

    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrRSS() {
        return strRSS;
    }

    public void setStrRSS(String strRSS) {
        this.strRSS = strRSS;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrDescriptionDE() {
        return strDescriptionDE;
    }

    public void setStrDescriptionDE(String strDescriptionDE) {
        this.strDescriptionDE = strDescriptionDE;
    }

    public String getStrDescriptionFR() {
        return strDescriptionFR;
    }

    public void setStrDescriptionFR(String strDescriptionFR) {
        this.strDescriptionFR = strDescriptionFR;
    }

    public String getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(String strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
    }

    public String getStrDescriptionCN() {
        return strDescriptionCN;
    }

    public void setStrDescriptionCN(String strDescriptionCN) {
        this.strDescriptionCN = strDescriptionCN;
    }

    public String getStrDescriptionJP() {
        return strDescriptionJP;
    }

    public void setStrDescriptionJP(String strDescriptionJP) {
        this.strDescriptionJP = strDescriptionJP;
    }

    public String getStrDescriptionRU() {
        return strDescriptionRU;
    }

    public void setStrDescriptionRU(String strDescriptionRU) {
        this.strDescriptionRU = strDescriptionRU;
    }

    public String getStrDescriptionES() {
        return strDescriptionES;
    }

    public void setStrDescriptionES(String strDescriptionES) {
        this.strDescriptionES = strDescriptionES;
    }

    public String getStrDescriptionPT() {
        return strDescriptionPT;
    }

    public void setStrDescriptionPT(String strDescriptionPT) {
        this.strDescriptionPT = strDescriptionPT;
    }

    public String getStrDescriptionSE() {
        return strDescriptionSE;
    }

    public void setStrDescriptionSE(String strDescriptionSE) {
        this.strDescriptionSE = strDescriptionSE;
    }

    public String getStrDescriptionNL() {
        return strDescriptionNL;
    }

    public void setStrDescriptionNL(String strDescriptionNL) {
        this.strDescriptionNL = strDescriptionNL;
    }

    public String getStrDescriptionHU() {
        return strDescriptionHU;
    }

    public void setStrDescriptionHU(String strDescriptionHU) {
        this.strDescriptionHU = strDescriptionHU;
    }

    public String getStrDescriptionNO() {
        return strDescriptionNO;
    }

    public void setStrDescriptionNO(String strDescriptionNO) {
        this.strDescriptionNO = strDescriptionNO;
    }

    public String getStrDescriptionPL() {
        return strDescriptionPL;
    }

    public void setStrDescriptionPL(String strDescriptionPL) {
        this.strDescriptionPL = strDescriptionPL;
    }

    public String getStrDescriptionIL() {
        return strDescriptionIL;
    }

    public void setStrDescriptionIL(String strDescriptionIL) {
        this.strDescriptionIL = strDescriptionIL;
    }

    public String getStrFanart1() {
        return strFanart1;
    }

    public void setStrFanart1(String strFanart1) {
        this.strFanart1 = strFanart1;
    }

    public String getStrFanart2() {
        return strFanart2;
    }

    public void setStrFanart2(String strFanart2) {
        this.strFanart2 = strFanart2;
    }

    public String getStrFanart3() {
        return strFanart3;
    }

    public void setStrFanart3(String strFanart3) {
        this.strFanart3 = strFanart3;
    }

    public String getStrFanart4() {
        return strFanart4;
    }

    public void setStrFanart4(String strFanart4) {
        this.strFanart4 = strFanart4;
    }

    public String getStrBanner() {
        return strBanner;
    }

    public void setStrBanner(String strBanner) {
        this.strBanner = strBanner;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public void setStrPoster(String strPoster) {
        this.strPoster = strPoster;
    }

    public String getStrTrophy() {
        return strTrophy;
    }

    public void setStrTrophy(String strTrophy) {
        this.strTrophy = strTrophy;
    }

    public String getStrNaming() {
        return strNaming;
    }

    public void setStrNaming(String strNaming) {
        this.strNaming = strNaming;
    }

    public String getStrComplete() {
        return strComplete;
    }

    public void setStrComplete(String strComplete) {
        this.strComplete = strComplete;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    @Override
    public String toString() {
        return "League{" +
                "idLeague='" + idLeague + '\'' +
                ", strSport='" + strSport + '\'' +
                ", strLeague='" + strLeague + '\'' +
                ", strGender='" + strGender + '\'' +
                ", strCountry='" + strCountry + '\'' +
                ", strWebsite='" + strWebsite + '\'' +
                ", strFacebook='" + strFacebook + '\'' +
                ", strTwitter='" + strTwitter + '\'' +
                ", strYoutube='" + strYoutube + '\'' +
                ", strDescriptionEN='" + strDescriptionEN + '\'' +
                ", strBadge='" + strBadge + '\'' +
                '}';
    }
}
