package com.daejong.ci_cdpractice.ui

import android.content.Intent
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import com.daejong.ci_cdpractice.MainActivity
import com.daejong.ci_cdpractice.R
import com.daejong.ci_cdpractice.SubActivity
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class MainActivityTest {

    @Test
    fun testToastMessage() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                // 1. A 버튼 클릭
                activity.findViewById<Button>(R.id.btn_a).performClick()

                // 2. 토스트 검증 (Robolectric 전용 메서드)
                val latestToast = ShadowToast.getLatestToast()
                assertThat(ShadowToast.getTextOfLatestToast(), `is`("테스트 토스트 테스트 토스트"))
            }
        }
    }

    @Test
    fun testNavigateToSubActivity() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                // 1. B 버튼 클릭
                activity.findViewById<Button>(R.id.btn_b).performClick()

                val targetIntent = Intent(activity, SubActivity::class.java)
                val actualIntent = Shadows.shadowOf(activity).nextStartedActivity
                assertThat(actualIntent.component, `is`(targetIntent.component))
            }
        }
    }
}