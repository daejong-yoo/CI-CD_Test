package com.daejong.ci_cdpractice

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `PR_테스트_승인_조건_확인`() {
        // 1 + 1이 2인지 확인하는 아주 단순한 테스트입니다.
        // 이 코드가 PR에 포함되어 있어야 "테스트 포함" 조건을 만족하게 됩니다.
        assert(2 == 1 + 1)
    }
}