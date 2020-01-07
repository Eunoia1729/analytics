package ai.elimu.analytics;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {StoryBookLearningEvent.class}, version = 3000001, exportSchema = true)
@TypeConverters({Converters.class})
public abstract class AnalyticsRoomDatabase extends RoomDatabase {

    public abstract StoryBookLearningEventDao storyBookLearningEventDao();

    private static volatile AnalyticsRoomDatabase INSTANCE;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    static final Migration MIGRATION_3000000_3000001 = new Migration(3000000, 3000001) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Log.i(getClass().getName(), "migrate (3000000 --> 3000001)");
            Calendar timestamp = Calendar.getInstance();
            String sql = "ALTER TABLE StoryBookLearningEvent ADD COLUMN timestamp INTEGER NOT NULL DEFAULT " + timestamp.getTimeInMillis();
            Log.i(getClass().getName(), "sql: " + sql);
            database.execSQL(sql);
        }
    };

    static AnalyticsRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AnalyticsRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(
                                    context.getApplicationContext(),
                                    AnalyticsRoomDatabase.class,
                                    "analytics_database"
                            )
                            .addMigrations(MIGRATION_3000000_3000001)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
