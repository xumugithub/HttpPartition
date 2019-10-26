package com.dcba.httppartition;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.dcba.httppartition.request.Callback;
import com.dcba.httppartition.separate.HttpPartition;
import com.dcba.httppartition.separate.Response;
import com.dcba.httppartition.test.B;
import com.dcba.httppartition.test.BaseConverter;
import com.dcba.httppartition.test.MyHttpClient;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.dcba.httppartition.test", appContext.getPackageName());

    }
}
