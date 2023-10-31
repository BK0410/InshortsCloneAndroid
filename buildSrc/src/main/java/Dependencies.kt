object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx" }
    val lifecycleRuntimeKtx by lazy {"androidx.lifecycle:lifecycle-runtime-ktx"}
    val activityCompose by lazy {"androidx.activity:activity-compose"}
    val composeBom by lazy {"androidx.compose:compose-bom"}
    val ui by lazy {"androidx.compose.ui:ui"}
    val uiGraphics by lazy {"androidx.compose.ui:ui-graphics"}
    val uiToolingPreview by lazy {"androidx.compose.ui:ui-tooling-preview"}
    val material3 by lazy {"androidx.compose.material3:material3"}
    val material by lazy {"com.google.android.material:material"}
    val appCompat by lazy {"androidx.appcompat:appcompat"}
    val hiltAndroid by lazy {"com.google.dagger:hilt-android"}
    val hiltAndroidCompiler by lazy {"com.google.dagger:hilt-android-compiler"}
    val hiltCompiler by lazy {"androidx.hilt:hilt-compiler"}
    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose"}
    val retrofit by lazy {"com.squareup.retrofit2:retrofit"}
    val okhttp by lazy {"com.squareup.okhttp3:okhttp"}
    val gsonConverter by lazy {"com.squareup.retrofit2:converter-gson"}
    val moshi by lazy {"com.squareup.moshi:moshi-kotlin"}
    val moshiConverter by lazy {"com.squareup.retrofit2:converter-moshi"}
    val loggingInterceptor by lazy {"com.squareup.okhttp3:logging-interceptor"}
    val coroutinesCore by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-core"}
    val coroutinesAndroid by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-android"}
    val splashscreen by lazy {"androidx.core:core-splashscreen"}
    val coil by lazy {"io.coil-kt:coil-compose"}


}

object Modules{
    const val utilities = ":utilities"
}