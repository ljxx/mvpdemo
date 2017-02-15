/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ylx.base;

import android.support.annotation.NonNull;

/**
 * ========================================
 * 描 述：persenter和activity绑定
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public interface IBaseDelegate<V extends IBaseView, P extends IBasePresenter<V>> {

    /**初始化presenter*/
    @NonNull
    P createPresenter();

    /**获取presenter*/
    @NonNull
    P getPresenter();

}

