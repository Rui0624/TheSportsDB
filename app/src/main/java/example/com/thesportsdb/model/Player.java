package example.com.thesportsdb.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "players")
public class Player implements Parcelable {

    @PrimaryKey
    @NonNull
    private String idPlayer;

    @ColumnInfo(name = "idTeam")
    private String idTeam;
    private String idTeam2;
    private String idTeamNational;
    private String idSoccerXML;
    private String idAPIfootball;
    private String idPlayerManager;

    @ColumnInfo(name = "nationality")
    private String strNationality;

    @ColumnInfo(name = "player")
    private String strPlayer;

    @ColumnInfo(name = "team")
    private String strTeam;
    private String strTeam2;

    @ColumnInfo(name = "sport")
    private String strSport;
    private String intSoccerXMLTeamID;

    @ColumnInfo(name = "dateBorn")
    private String dateBorn;
    private String strNumber;
    private String dateSigned;
    private String strSigning;
    private String strWage;
    private String strOutfitter;
    private String strKit;
    private String strAgent;
    private String strBirthLocation;

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
    private String strSide;

    @ColumnInfo(name = "position")
    private String strPosition;
    private String strCollege;

    @ColumnInfo(name = "facebook")
    private String strFacebook;

    @ColumnInfo(name = "website")
    private String strWebsite;

    @ColumnInfo(name = "twitter")
    private String strTwitter;

    @ColumnInfo(name = "instagram")
    private String strInstagram;

    @ColumnInfo(name = "youtube")
    private String strYoutube;

    @ColumnInfo(name = "height")
    private String strHeight;

    @ColumnInfo(name = "weight")
    private String strWeight;
    private String intLoved;

    @ColumnInfo(name = "thumb")
    private String strThumb;
    private String strCutout;
    private String strRender;
    private String strBanner;
    private String strFanart1;
    private String strFanart2;
    private String strFanart3;
    private String strFanart4;
    private String strCreativeCommons;
    private String strLocked;


    public Player(String idPlayer, String idTeam, String idTeam2, String idTeamNational, String idSoccerXML, String idAPIfootball, String idPlayerManager, String strNationality, String strPlayer, String strTeam, String strTeam2, String strSport, String intSoccerXMLTeamID, String dateBorn, String strNumber, String dateSigned, String strSigning, String strWage, String strOutfitter, String strKit, String strAgent, String strBirthLocation, String strDescriptionEN, String strDescriptionDE, String strDescriptionFR, String strDescriptionCN, String strDescriptionIT, String strDescriptionJP, String strDescriptionRU, String strDescriptionES, String strDescriptionPT, String strDescriptionSE, String strDescriptionNL, String strDescriptionHU, String strDescriptionNO, String strDescriptionIL, String strDescriptionPL, String strGender, String strSide, String strPosition, String strCollege, String strFacebook, String strWebsite, String strTwitter, String strInstagram, String strYoutube, String strHeight, String strWeight, String intLoved, String strThumb, String strCutout, String strRender, String strBanner, String strFanart1, String strFanart2, String strFanart3, String strFanart4, String strCreativeCommons, String strLocked) {
        this.idPlayer = idPlayer;
        this.idTeam = idTeam;
        this.idTeam2 = idTeam2;
        this.idTeamNational = idTeamNational;
        this.idSoccerXML = idSoccerXML;
        this.idAPIfootball = idAPIfootball;
        this.idPlayerManager = idPlayerManager;
        this.strNationality = strNationality;
        this.strPlayer = strPlayer;
        this.strTeam = strTeam;
        this.strTeam2 = strTeam2;
        this.strSport = strSport;
        this.intSoccerXMLTeamID = intSoccerXMLTeamID;
        this.dateBorn = dateBorn;
        this.strNumber = strNumber;
        this.dateSigned = dateSigned;
        this.strSigning = strSigning;
        this.strWage = strWage;
        this.strOutfitter = strOutfitter;
        this.strKit = strKit;
        this.strAgent = strAgent;
        this.strBirthLocation = strBirthLocation;
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
        this.strSide = strSide;
        this.strPosition = strPosition;
        this.strCollege = strCollege;
        this.strFacebook = strFacebook;
        this.strWebsite = strWebsite;
        this.strTwitter = strTwitter;
        this.strInstagram = strInstagram;
        this.strYoutube = strYoutube;
        this.strHeight = strHeight;
        this.strWeight = strWeight;
        this.intLoved = intLoved;
        this.strThumb = strThumb;
        this.strCutout = strCutout;
        this.strRender = strRender;
        this.strBanner = strBanner;
        this.strFanart1 = strFanart1;
        this.strFanart2 = strFanart2;
        this.strFanart3 = strFanart3;
        this.strFanart4 = strFanart4;
        this.strCreativeCommons = strCreativeCommons;
        this.strLocked = strLocked;
    }


    protected Player(Parcel in) {
        idPlayer = in.readString();
        idTeam = in.readString();
        idTeam2 = in.readString();
        idTeamNational = in.readString();
        idSoccerXML = in.readString();
        idAPIfootball = in.readString();
        idPlayerManager = in.readString();
        strNationality = in.readString();
        strPlayer = in.readString();
        strTeam = in.readString();
        strTeam2 = in.readString();
        strSport = in.readString();
        intSoccerXMLTeamID = in.readString();
        dateBorn = in.readString();
        strNumber = in.readString();
        dateSigned = in.readString();
        strSigning = in.readString();
        strWage = in.readString();
        strOutfitter = in.readString();
        strKit = in.readString();
        strAgent = in.readString();
        strBirthLocation = in.readString();
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
        strSide = in.readString();
        strPosition = in.readString();
        strCollege = in.readString();
        strFacebook = in.readString();
        strWebsite = in.readString();
        strTwitter = in.readString();
        strInstagram = in.readString();
        strYoutube = in.readString();
        strHeight = in.readString();
        strWeight = in.readString();
        intLoved = in.readString();
        strThumb = in.readString();
        strCutout = in.readString();
        strRender = in.readString();
        strBanner = in.readString();
        strFanart1 = in.readString();
        strFanart2 = in.readString();
        strFanart3 = in.readString();
        strFanart4 = in.readString();
        strCreativeCommons = in.readString();
        strLocked = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player( in );
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(String idTeam2) {
        this.idTeam2 = idTeam2;
    }

    public String getIdTeamNational() {
        return idTeamNational;
    }

    public void setIdTeamNational(String idTeamNational) {
        this.idTeamNational = idTeamNational;
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

    public String getIdPlayerManager() {
        return idPlayerManager;
    }

    public void setIdPlayerManager(String idPlayerManager) {
        this.idPlayerManager = idPlayerManager;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeam2() {
        return strTeam2;
    }

    public void setStrTeam2(String strTeam2) {
        this.strTeam2 = strTeam2;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getIntSoccerXMLTeamID() {
        return intSoccerXMLTeamID;
    }

    public void setIntSoccerXMLTeamID(String intSoccerXMLTeamID) {
        this.intSoccerXMLTeamID = intSoccerXMLTeamID;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getStrNumber() {
        return strNumber;
    }

    public void setStrNumber(String strNumber) {
        this.strNumber = strNumber;
    }

    public String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getStrSigning() {
        return strSigning;
    }

    public void setStrSigning(String strSigning) {
        this.strSigning = strSigning;
    }

    public String getStrWage() {
        return strWage;
    }

    public void setStrWage(String strWage) {
        this.strWage = strWage;
    }

    public String getStrOutfitter() {
        return strOutfitter;
    }

    public void setStrOutfitter(String strOutfitter) {
        this.strOutfitter = strOutfitter;
    }

    public String getStrKit() {
        return strKit;
    }

    public void setStrKit(String strKit) {
        this.strKit = strKit;
    }

    public String getStrAgent() {
        return strAgent;
    }

    public void setStrAgent(String strAgent) {
        this.strAgent = strAgent;
    }

    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
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

    public String getStrSide() {
        return strSide;
    }

    public void setStrSide(String strSide) {
        this.strSide = strSide;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public String getStrCollege() {
        return strCollege;
    }

    public void setStrCollege(String strCollege) {
        this.strCollege = strCollege;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
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

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    public String getStrWeight() {
        return strWeight;
    }

    public void setStrWeight(String strWeight) {
        this.strWeight = strWeight;
    }

    public String getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(String intLoved) {
        this.intLoved = intLoved;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public String getStrCutout() {
        return strCutout;
    }

    public void setStrCutout(String strCutout) {
        this.strCutout = strCutout;
    }

    public String getStrRender() {
        return strRender;
    }

    public void setStrRender(String strRender) {
        this.strRender = strRender;
    }

    public String getStrBanner() {
        return strBanner;
    }

    public void setStrBanner(String strBanner) {
        this.strBanner = strBanner;
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

    public String getStrCreativeCommons() {
        return strCreativeCommons;
    }

    public void setStrCreativeCommons(String strCreativeCommons) {
        this.strCreativeCommons = strCreativeCommons;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( idPlayer );
        parcel.writeString( idTeam );
        parcel.writeString( idTeam2 );
        parcel.writeString( idTeamNational );
        parcel.writeString( idSoccerXML );
        parcel.writeString( idAPIfootball );
        parcel.writeString( idPlayerManager );
        parcel.writeString( strNationality );
        parcel.writeString( strPlayer );
        parcel.writeString( strTeam );
        parcel.writeString( strTeam2 );
        parcel.writeString( strSport );
        parcel.writeString( intSoccerXMLTeamID );
        parcel.writeString( dateBorn );
        parcel.writeString( strNumber );
        parcel.writeString( dateSigned );
        parcel.writeString( strSigning );
        parcel.writeString( strWage );
        parcel.writeString( strOutfitter );
        parcel.writeString( strKit );
        parcel.writeString( strAgent );
        parcel.writeString( strBirthLocation );
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
        parcel.writeString( strSide );
        parcel.writeString( strPosition );
        parcel.writeString( strCollege );
        parcel.writeString( strFacebook );
        parcel.writeString( strWebsite );
        parcel.writeString( strTwitter );
        parcel.writeString( strInstagram );
        parcel.writeString( strYoutube );
        parcel.writeString( strHeight );
        parcel.writeString( strWeight );
        parcel.writeString( intLoved );
        parcel.writeString( strThumb );
        parcel.writeString( strCutout );
        parcel.writeString( strRender );
        parcel.writeString( strBanner );
        parcel.writeString( strFanart1 );
        parcel.writeString( strFanart2 );
        parcel.writeString( strFanart3 );
        parcel.writeString( strFanart4 );
        parcel.writeString( strCreativeCommons );
        parcel.writeString( strLocked );
    }
}

