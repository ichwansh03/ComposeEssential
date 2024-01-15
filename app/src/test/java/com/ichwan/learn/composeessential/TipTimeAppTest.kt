package com.ichwan.learn.composeessential

import com.ichwan.learn.composeessential.tiptimeapp.calculateTip
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotSame
import org.junit.Test
import java.text.NumberFormat

class TipTimeAppTest {

    @Test
    fun calculateTip_20PercentNoRoundupAndSuccess() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_20PercentNoRoundupAndFailed() {
        val amount = 13.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertNotSame(expectedTip, actualTip)
    }
}