package com.dev.habity.View.HabityWidget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class HabityWidgetReceiver() : GlanceAppWidgetReceiver(){
    override val glanceAppWidget: GlanceAppWidget
        get() = HabityWidget()
}