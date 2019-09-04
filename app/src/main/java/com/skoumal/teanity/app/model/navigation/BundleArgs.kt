package com.skoumal.teanity.app.model.navigation

import android.os.Bundle
import com.skoumal.teanity.app.model.internal.Photo

var Bundle.photo: Photo
    set(value) = putParcelable("photo", value)
    get() = getParcelable("photo")!!
