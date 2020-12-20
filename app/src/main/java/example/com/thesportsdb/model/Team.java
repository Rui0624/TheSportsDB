package example.com.thesportsdb.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teams")
public class Team implements Parcelable {

    @PrimaryKey
    @NonNull
    private String idTeam;

    private String idSoccerXML;
    private String idAPIfootball;
    private String intLoved;

    @ColumnInfo(name = "team")
    private String strTeam;
    private String strTeamShort;

    @ColumnInfo(name = "alternate")
    private String strAlternate;
    private String intFormedYear;
    private String strSport;

    @ColumnInfo(name = "league")
    private String strLeague;
    @ColumnInfo(name = "idLeague")
    private String idLeague;
    private String strDivision;
    private String strManager;
    private String strStadium;
    private String strKeywords;
    private String strRSS;
    private String strStadiumThumb;
    private String strStadiumDescription;
    private String strStadiumLocation;
    private String intStadiumCapacity;

    @ColumnInfo(name = "website")
    private String strWebsite;

    @ColumnInfo(name = "facebook")
    private String strFacebook;

    @ColumnInfo(name = "twitter")
    private String strTwitter;

    @ColumnInfo(name = "instagram")
    private String strInstagram;

    @ColumnInfo(name = "description")
    private String strDescriptionEN;
    private String strDescriptionDE;
    private String strDescriptionFR;
    private String strDescriptionCN;
    private String strDescriptionIT;
    private String strDescriptionJP;
    private String strDescriptionRU;
    private String strDescriptionES;
    private String strDescriptionPT;
    private String strDescriptionSE;
    private String strDescriptionNL;
    private String strDescriptionHU;
    private String strDescriptionNO;
    private String strDescriptionIL;
    private String strDescriptionPL;

    @ColumnInfo(name = "gender")
    private String strGender;

    @ColumnInfo(name = "country")
    private String strCountry;

    @ColumnInfo(name = "badge")
    private String strTeamBadge;
    private String strTeamJersey;
    private String strTeamLogo;
    private String strTeamFanart1;
    private String strTeamFanart2;
    private String strTeamFanart3;
    private String strTeamFanart4;
    private String strTeamBanner;

    @ColumnInfo(name = "youtube")
    private String strYoutube;
    private String strLocked;

    public String getStrTeamFanart2() {
        return strTeamFanart2;
    }

    public void setStrTeamFanart2(String strTeamFanart2) {
        this.strTeamFanart2 = strTeamFanart2;
    }

    public String getStrTeamFanart3() {
        return strTeamFanart3;
    }

    public void setStrTeamFanart3(String strTeamFanart3) {
        this.strTeamFanart3 = strTeamFanart3;
    }

    public String getStrTeamFanart4() {
        return strTeamFanart4;
    }

    public void setStrTeamFanart4(String strTeamFanart4) {
        this.strTeamFanart4 = strTeamFanart4;
    }

    public String getStrTeamBanner() {
        return strTeamBanner;
    }

    public void setStrTeamBanner(String strTeamBanner) {
        this.strTeamBanner = strTeamBanner;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    public static Creator<Team> getCREATOR() {
        return CREATOR;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
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

    public String getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(String intLoved) {
        this.intLoved = intLoved;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public void setStrTeamShort(String strTeamShort) {
        this.strTeamShort = strTeamShort;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
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

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrDivision() {
        return strDivision;
    }

    public void setStrDivision(String strDivision) {
        this.strDivision = strDivision;
    }

    public String getStrManager() {
        return strManager;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrKeywords() {
        return strKeywords;
    }

    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    public String getStrRSS() {
        return strRSS;
    }

    public void setStrRSS(String strRSS) {
        this.strRSS = strRSS;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(String intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
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

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
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

    public String getStrDescriptionCN() {
        return strDescriptionCN;
    }

    public void setStrDescriptionCN(String strDescriptionCN) {
        this.strDescriptionCN = strDescriptionCN;
    }

    public String getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(String strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
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

    public String getStrDescriptionIL() {
        return strDescriptionIL;
    }

    public void setStrDescriptionIL(String strDescriptionIL) {
        this.strDescriptionIL = strDescriptionIL;
    }

    public String getStrDescriptionPL() {
        return strDescriptionPL;
    }

    public void setStrDescriptionPL(String strDescriptionPL) {
        this.strDescriptionPL = strDescriptionPL;
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

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }

    public String getStrTeamFanart1() {
        return strTeamFanart1;
    }

    public void setStrTeamFanart1(String strTeamFanart1) {
        this.strTeamFanart1 = strTeamFanart1;
    }

    public Team(String idTeam, String idSoccerXML, String idAPIfootball,
                String intLoved, String strTeam, String strTeamShort,
                String strAlternate, String intFormedYear, String strSport,
                String strLeague, String idLeague, String strDivision,
                String strManager, String strStadium, String strKeywords,
                String strRSS, String strStadiumThumb,
                String strStadiumDescription, String strStadiumLocation,
                String intStadiumCapacity, String strWebsite,
                String strFacebook, String strTwitter, String strInstagram,
                String strDescriptionEN, String strDescriptionDE,
                String strDescriptionFR, String strDescriptionCN,
                String strDescriptionIT, String strDescriptionJP,
                String strDescriptionRU, String strDescriptionES,
                String strDescriptionPT, String strDescriptionSE,
                String strDescriptionNL, String strDescriptionHU, String strDescriptionNO,
                String strDescriptionIL, String strDescriptionPL, String strGender,
                String strCountry, String strTeamBadge, String strTeamJersey,
                String strTeamLogo, String strTeamFanart1, String strTeamFanart2,
                String strTeamFanart3, String strTeamFanart4, String strTeamBanner,
                String strYoutube, String strLocked) {
        this.idTeam = idTeam;
        this.idSoccerXML = idSoccerXML;
        this.idAPIfootball = idAPIfootball;
        this.intLoved = intLoved;
        this.strTeam = strTeam;
        this.strTeamShort = strTeamShort;
        this.strAlternate = strAlternate;
        this.intFormedYear = intFormedYear;
        this.strSport = strSport;
        this.strLeague = strLeague;
        this.idLeague = idLeague;
        this.strDivision = strDivision;
        this.strManager = strManager;
        this.strStadium = strStadium;
        this.strKeywords = strKeywords;
        this.strRSS = strRSS;
        this.strStadiumThumb = strStadiumThumb;
        this.strStadiumDescription = strStadiumDescription;
        this.strStadiumLocation = strStadiumLocation;
        this.intStadiumCapacity = intStadiumCapacity;
        this.strWebsite = strWebsite;
        this.strFacebook = strFacebook;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;
        this.strDescriptionEN = strDescriptionEN;
        this.strDescriptionDE = strDescriptionDE;
        this.strDescriptionFR = strDescriptionFR;
        this.strDescriptionCN = strDescriptionCN;
        this.strDescriptionIT = strDescriptionIT;
        this.strDescriptionJP = strDescriptionJP;
        this.strDescriptionRU = strDescriptionRU;
        this.strDescriptionES = strDescriptionES;
        this.strDescriptionPT = strDescriptionPT;
        this.strDescriptionSE = strDescriptionSE;
        this.strDescriptionNL = strDescriptionNL;
        this.strDescriptionHU = strDescriptionHU;
        this.strDescriptionNO = strDescriptionNO;
        this.strDescriptionIL = strDescriptionIL;
        this.strDescriptionPL = strDescriptionPL;
        this.strGender = strGender;
        this.strCountry = strCountry;
        this.strTeamBadge = strTeamBadge;
        this.strTeamJersey = strTeamJersey;
        this.strTeamLogo = strTeamLogo;
        this.strTeamFanart1 = strTeamFanart1;
        this.strTeamFanart2 = strTeamFanart2;
        this.strTeamFanart3 = strTeamFanart3;
        this.strTeamFanart4 = strTeamFanart4;
        this.strTeamBanner = strTeamBanner;
        this.strYoutube = strYoutube;
        this.strLocked = strLocked;
    }

    protected Team(Parcel in) {
        idTeam = in.readString();
        idSoccerXML = in.readString();
        idAPIfootball = in.readString();
        intLoved = in.readString();
        strTeam = in.readString();
        strTeamShort = in.readString();
        strAlternate = in.readString();
        intFormedYear = in.readString();
        strSport = in.readString();
        strLeague = in.readString();
        idLeague = in.readString();
        strDivision = in.readString();
        strManager = in.readString();
        strStadium = in.readString();
        strKeywords = in.readString();
        strRSS = in.readString();
        strStadiumThumb = in.readString();
        strStadiumDescription = in.readString();
        strStadiumLocation = in.readString();
        intStadiumCapacity = in.readString();
        strWebsite = in.readString();
        strFacebook = in.readString();
        strTwitter = in.readString();
        strInstagram = in.readString();
        strDescriptionEN = in.readString();
        strDescriptionDE = in.readString();
        strDescriptionFR = in.readString();
        strDescriptionCN = in.readString();
        strDescriptionIT = in.readString();
        strDescriptionJP = in.readString();
        strDescriptionRU = in.readString();
        strDescriptionES = in.readString();
        strDescriptionPT = in.readString();
        strDescriptionSE = in.readString();
        strDescriptionNL = in.readString();
        strDescriptionHU = in.readString();
        strDescriptionNO = in.readString();
        strDescriptionIL = in.readString();
        strDescriptionPL = in.readString();
        strGender = in.readString();
        strCountry = in.readString();
        strTeamBadge = in.readString();
        strTeamJersey = in.readString();
        strTeamLogo = in.readString();
        strTeamFanart1 = in.readString();
        strTeamFanart2 = in.readString();
        strTeamFanart3 = in.readString();
        strTeamFanart4 = in.readString();
        strTeamBanner = in.readString();
        strYoutube = in.readString();
        strLocked = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team( in );
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( idTeam );
        parcel.writeString( idSoccerXML );
        parcel.writeString( idAPIfootball );
        parcel.writeString( intLoved );
        parcel.writeString( strTeam );
        parcel.writeString( strTeamShort );
        parcel.writeString( strAlternate );
        parcel.writeString( intFormedYear );
        parcel.writeString( strSport );
        parcel.writeString( strLeague );
        parcel.writeString( idLeague );
        parcel.writeString( strDivision );
        parcel.writeString( strManager );
        parcel.writeString( strStadium );
        parcel.writeString( strKeywords );
        parcel.writeString( strRSS );
        parcel.writeString( strStadiumThumb );
        parcel.writeString( strStadiumDescription );
        parcel.writeString( strStadiumLocation );
        parcel.writeString( intStadiumCapacity );
        parcel.writeString( strWebsite );
        parcel.writeString( strFacebook );
        parcel.writeString( strTwitter );
        parcel.writeString( strInstagram );
        parcel.writeString( strDescriptionEN );
        parcel.writeString( strDescriptionDE );
        parcel.writeString( strDescriptionFR );
        parcel.writeString( strDescriptionCN );
        parcel.writeString( strDescriptionIT );
        parcel.writeString( strDescriptionJP );
        parcel.writeString( strDescriptionRU );
        parcel.writeString( strDescriptionES );
        parcel.writeString( strDescriptionPT );
        parcel.writeString( strDescriptionSE );
        parcel.writeString( strDescriptionNL );
        parcel.writeString( strDescriptionHU );
        parcel.writeString( strDescriptionNO );
        parcel.writeString( strDescriptionIL );
        parcel.writeString( strDescriptionPL );
        parcel.writeString( strGender );
        parcel.writeString( strCountry );
        parcel.writeString( strTeamBadge );
        parcel.writeString( strTeamJersey );
        parcel.writeString( strTeamLogo );
        parcel.writeString( strTeamFanart1 );
        parcel.writeString( strTeamFanart2 );
        parcel.writeString( strTeamFanart3 );
        parcel.writeString( strTeamFanart4 );
        parcel.writeString( strTeamBanner );
        parcel.writeString( strYoutube );
        parcel.writeString( strLocked );
    }

    @Override
    public String toString() {
        return "Team{" +
                "idTeam='" + idTeam + '\'' +
                ", idSoccerXML='" + idSoccerXML + '\'' +
                ", idAPIfootball='" + idAPIfootball + '\'' +
                ", intLoved='" + intLoved + '\'' +
                ", strTeam='" + strTeam + '\'' +
                ", strTeamShort='" + strTeamShort + '\'' +
                ", strAlternate='" + strAlternate + '\'' +
                ", intFormedYear='" + intFormedYear + '\'' +
                ", strSport='" + strSport + '\'' +
                ", strLeague='" + strLeague + '\'' +
                ", idLeague='" + idLeague + '\'' +
                ", strDivision='" + strDivision + '\'' +
                ", strManager='" + strManager + '\'' +
                ", strStadium='" + strStadium + '\'' +
                ", strKeywords='" + strKeywords + '\'' +
                ", strRSS='" + strRSS + '\'' +
                ", strStadiumThumb='" + strStadiumThumb + '\'' +
                ", strStadiumDescription='" + strStadiumDescription + '\'' +
                ", strStadiumLocation='" + strStadiumLocation + '\'' +
                ", intStadiumCapacity='" + intStadiumCapacity + '\'' +
                ", strWebsite='" + strWebsite + '\'' +
                ", strFacebook='" + strFacebook + '\'' +
                ", strTwitter='" + strTwitter + '\'' +
                ", strInstagram='" + strInstagram + '\'' +
                ", strDescriptionEN='" + strDescriptionEN + '\'' +
                ", strDescriptionDE='" + strDescriptionDE + '\'' +
                ", strDescriptionFR='" + strDescriptionFR + '\'' +
                ", strDescriptionCN='" + strDescriptionCN + '\'' +
                ", strDescriptionIT='" + strDescriptionIT + '\'' +
                ", strDescriptionJP='" + strDescriptionJP + '\'' +
                ", strDescriptionRU='" + strDescriptionRU + '\'' +
                ", strDescriptionES='" + strDescriptionES + '\'' +
                ", strDescriptionPT='" + strDescriptionPT + '\'' +
                ", strDescriptionSE='" + strDescriptionSE + '\'' +
                ", strDescriptionNL='" + strDescriptionNL + '\'' +
                ", strDescriptionHU='" + strDescriptionHU + '\'' +
                ", strDescriptionNO='" + strDescriptionNO + '\'' +
                ", strDescriptionIL='" + strDescriptionIL + '\'' +
                ", strDescriptionPL='" + strDescriptionPL + '\'' +
                ", strGender='" + strGender + '\'' +
                ", strCountry='" + strCountry + '\'' +
                ", strTeamBadge='" + strTeamBadge + '\'' +
                ", strTeamJersey='" + strTeamJersey + '\'' +
                ", strTeamLogo='" + strTeamLogo + '\'' +
                ", strTeamFanart1='" + strTeamFanart1 + '\'' +
                ", strTeamFanart2='" + strTeamFanart2 + '\'' +
                ", strTeamFanart3='" + strTeamFanart3 + '\'' +
                ", strTeamFanart4='" + strTeamFanart4 + '\'' +
                ", strTeamBanner='" + strTeamBanner + '\'' +
                ", strYoutube='" + strYoutube + '\'' +
                ", strLocked='" + strLocked + '\'' +
                '}';
    }
}
