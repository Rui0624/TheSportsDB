package example.com.thesportsdb.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "sports")
class Sport(@PrimaryKey @NotNull var idSport: String, @ColumnInfo(name = "sport") var strSport: String?, @ColumnInfo(name = "format") var strFormat: String?,
            @ColumnInfo(name = "sportThumb") var strSportThumb: String?, @ColumnInfo(name = "sportThumbGreen") var strSportThumbGreen: String?, @ColumnInfo(name = "sportDescription") var strSportDescription: String?): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idSport)
        parcel.writeString(strSport)
        parcel.writeString(strFormat)
        parcel.writeString(strSportThumb)
        parcel.writeString(strSportThumbGreen)
        parcel.writeString(strSportDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sport> {
        override fun createFromParcel(parcel: Parcel): Sport {
            return Sport(parcel)
        }

        override fun newArray(size: Int): Array<Sport?> {
            return arrayOfNulls(size)
        }
    }

}