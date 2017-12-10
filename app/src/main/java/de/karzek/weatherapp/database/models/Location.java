package de.karzek.weatherapp.database.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Marjana Karzek on 10.12.2017.
 */

@Table(name = Location.TABLE_NAME)
public class Location extends Model {

    //Table name
    public static  final String TABLE_NAME = "Locations";

    //Columns
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";

    @Column(name = COLUMN_ID,
            unique = true,
            onUniqueConflict = Column.ConflictAction.REPLACE,
            index = true)
    private String id;

    @Column(name = COLUMN_NAME)
    private String name;

    @Column(name = COLUMN_LATITUDE)
    private String latitude;

    @Column(name = COLUMN_LONGITUDE)
    private String longitude;

}
