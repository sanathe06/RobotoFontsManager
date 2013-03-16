/*
 * Copyright 2012 Sanath Nandasiri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.guide.robotofontsmanager.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.android.guide.robotofontsmanager.RobotoFontManager;
import com.android.guide.robotofontsmanager.RobotoFontManager.RobotoType;

/**
 * @author Sanath Nandasiri
 *
 */
public class RobotoTextView extends TextView {

	public RobotoTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if(!isInEditMode()){
			this.setRobotoTypeFace(RobotoFontManager.getFrontByAttributeSet(context, attrs));			
		}
	}

	public RobotoTextView(Context context) {
		super(context);
	}
	
	/**
	 * Used to set RobotoTypeFace 
	 * @param robotoType {@link RobotoType}
	 */
	public void setRobotoTypeFace(RobotoType robotoType){
	    Typeface typeface = Typeface.createFromAsset(this.getContext().getAssets(), robotoType.fileName);
	    this.setTypeface(typeface);
	}
}
