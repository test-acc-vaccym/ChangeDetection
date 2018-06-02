package com.bernaferrari.changedetection.forms

import android.content.Context
import android.text.InputType
import com.bernaferrari.changedetection.R
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.iconics.typeface.IIcon
import com.orhanobut.logger.Logger

object Forms {

    const val NAME = "name"
    const val URL = "url"

    internal fun getHint(context: Context, input: String): String {
        return when (input) {
            Forms.NAME -> context.getString(R.string.inputName)
            Forms.URL -> context.getString(R.string.inputUrl)
            else -> ""
        }
    }

    internal fun inputType(kind: String): Int {
        return when (kind) {
            Forms.URL -> InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
            else -> InputType.TYPE_CLASS_TEXT
        }
    }

    internal fun getIcon(kind: String): IIcon {
        return when (kind) {
            Forms.URL -> CommunityMaterial.Icon.cmd_web
            Forms.NAME -> GoogleMaterial.Icon.gmd_edit
            else -> GoogleMaterial.Icon.gmd_error
        }
    }

    internal fun saveData(
        listOfItems: MutableList<FormSingleEditText>
    ): MutableMap<String, Any?> {
        return mutableMapOf<String, Any?>().apply {
            listOfItems.forEach { item ->
                this[item.kind] = item.retrieveText()
            }
            Logger.d("returning map: $this")
        }
    }
}