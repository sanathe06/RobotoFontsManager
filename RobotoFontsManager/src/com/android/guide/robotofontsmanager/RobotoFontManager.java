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
package com.android.guide.robotofontsmanager;

import java.util.EnumMap;
import java.util.Map;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.guide.robotofontsmanager.widget.RobotoEditText;
import com.android.guide.robotofontsmanager.widget.RobotoTextView;

/**
 * @author Sanath Nandasiri
 * 
 * </br>
 * 
 * Managing RobotoTypeFace in pre HoneyComb devices
 *
 */
public class RobotoFontManager {
	
	/** 
	 * cache for holding already created TypeFace
	 */
	private static Map<RobotoType, Typeface> typefaceCache = new EnumMap<RobotoType, Typeface>(RobotoType.class);
	
	/**
	 * Used to create {@link Typeface}  from assest for selected {@link RobotoType}
	 * 
	 * @param context {@link Context}
	 * @param robotoType {@link RobotoType}
	 * @return  {@link Typeface}
	 */
	public static Typeface getRobotoTypeFace(Context context,RobotoType robotoType){
		if(!typefaceCache.containsKey(robotoType)){
			Typeface typeface = Typeface.createFromAsset(context.getAssets(), robotoType.fileName);
			typefaceCache.put(robotoType, typeface);		
		}
		return typefaceCache.get(robotoType);
	}
	
	/**
	 * Used to apply Roboto style font to any view 
	 * 
	 * @param context {@link Context}
	 * @param view {@link View}
	 * @param robotoTypeFace {@link RobotoType}
	 */
	public static void setFont(Context context,View view, RobotoType fontType){
		setFont(view,getRobotoTypeFace(context,fontType));
	}
	
	/**
	 * set selected  TypeFace  for all {@link TextView} in {@link View}  
	 * @param view  {@link View}
	 * @param robotoTypeFace {@link Typeface}
	 */
	private static void setFont(View view, Typeface typeFace)
    {
        if (view instanceof ViewGroup)
        {
            for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++)
            {
                setFont(((ViewGroup)view).getChildAt(i), typeFace);
            }
        }
        else if (view instanceof TextView)
        {
            ((TextView) view).setTypeface(typeFace);
        }
    }
	
	/**
	 * This method is using for creating TypeFace according to Style Attribute robotoTypeFace in {@link RobotoTextView} and {@link RobotoEditText}
	 * @param context {@link Context} for obtains styled attributes
	 * @param attrs AttributeSet set for View
	 * @return {@link RobotoType} that selected by style
	 */
	public static RobotoType getFrontByAttributeSet(Context context, AttributeSet attrs){
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.RobotoTextView);
		if (a.length() > 0) {
			int fontId = -1;
			for (int i = 0; i < a.length(); i++) {
				int attr = a.getIndex(i);
				if (attr == R.styleable.RobotoTextView_robotoTypeFace) {
					fontId = a.getInt(attr, -1);
				}
			}

			if (fontId != -1) {
				return getFontbyId(fontId);
			}
		}
		a.recycle();
		return null;	
	}
	
	
	/**
	 * This is RobotoTypeFace enum includes all robotofonts
	 * This is cause to your application size.
	 * If you are using this manager in your application make sure to include necessary  fonts only.
	 * to remove or add fonts here you need to  edit {@link #getFontbyId( int ) getFontbyId}
	 */
	public enum RobotoType {
		RobotoBlack("fonts/Roboto-Black.ttf"), 
		RobotoBlackItalic("fonts/Roboto-BlackItalic.ttf"), 
		RobotoBold("fonts/Roboto-Bold.ttf"), 
		RobotoBoldCondensed("fonts/Roboto-BoldCondensed.ttf"), 
		RobotoBoldCondensedItalic("fonts/Roboto-CondensedItalic.ttf"),
		RobotoBoldItalic("fonts/Roboto-BoldItalic.ttf"),
		RobotoCondensed("fonts/Roboto-Condensed.ttf"),
		RobotoCondensedItalic("fonts/Roboto-CondensedItalic.ttf"),
		RobotoItalic("fonts/Roboto-Italic.ttf"),
		RobotoLight("fonts/Roboto-Light.ttf"),
		RobotoLightItalic("fonts/Roboto-LightItalic.ttf"),
		RobotoMedium("fonts/Roboto-Medium.ttf"),
		RobotoMediumItalic("fonts/Roboto-MediumItalic.ttf"),
		RobotoRegular("fonts/Roboto-Regular.ttf"),
		RobotoThin("fonts/Roboto-Thin.ttf"), 
		RobotoThinItalic("fonts/Roboto-ThinItalic.ttf");
		
	    public final String fileName;
	 
	    private RobotoType(String name) {
	      fileName = name;
	    }
	  }
	
	/**
	 * @param id
	 * @return
	 */
	private static  RobotoType getFontbyId(int id){
			switch (id) {
			case 0:
				return RobotoType.RobotoBlack;
			case 1:
				return RobotoType.RobotoBlackItalic;
			case 2:
				return RobotoType.RobotoBold;
			case 3:
				return RobotoType.RobotoBoldCondensed;
			case 4:
				return RobotoType.RobotoBoldCondensedItalic;
			case 5:
				return RobotoType.RobotoBoldItalic;
			case 6:
				return RobotoType.RobotoCondensed;
			case 7:
				return RobotoType.RobotoCondensedItalic;
			case 8:
				return RobotoType.RobotoItalic;
			case 9:
				return RobotoType.RobotoLight;
			case 10:
				return RobotoType.RobotoLightItalic;
			case 11:
				return RobotoType.RobotoMedium;
			case 12:
				return RobotoType.RobotoMediumItalic;
			case 13:
				return RobotoType.RobotoRegular;
			case 14:
				return RobotoType.RobotoThin;
			case 15:
				return RobotoType.RobotoThinItalic;
		}
		return null;
	}
}
