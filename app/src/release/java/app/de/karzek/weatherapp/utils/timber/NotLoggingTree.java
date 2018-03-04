package app.de.karzek.weatherapp.utils.timber;

import timber.log.Timber;

/**
 * Created by MarjanaKarzek on 04.03.2018.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 04.03.2018
 */

public class NotLoggingTree extends Timber.Tree {

    @Override
    protected void log(final int priority, final String tag, final String message, final Throwable throwable) {
    }
}
