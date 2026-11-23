package dev.skramer.dashcam;

import android.os.Build;
import java.util.Locale;

/*
 * This holds an identifier that represents the car the head unit is in.
 * There are some places where the code will differ by model
 */
enum Model {
    NEEV_CVEV,  // IONIQ 5 (neev) and EV6 (cvev): the firmware this project was written for, treated as the default.
    DE22EV;     // 2022 Niro EV (de22ev)

    /** From the build name: wp_daudioplus_neev23_us, wp_daudioplus_de22ev_us, ... */
    static final Model CURRENT = detect(Build.DEVICE);

    static Model detect(String device) {
        String d = device == null ? "" : device.toLowerCase(Locale.US);
        if (d.contains("_de22ev")) return DE22EV;
        return NEEV_CVEV;
    }
}