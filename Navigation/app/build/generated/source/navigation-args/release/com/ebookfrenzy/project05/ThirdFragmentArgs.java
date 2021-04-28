package com.ebookfrenzy.project05;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ThirdFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ThirdFragmentArgs() {
  }

  private ThirdFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ThirdFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ThirdFragmentArgs __result = new ThirdFragmentArgs();
    bundle.setClassLoader(ThirdFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Image2")) {
      int Image2;
      Image2 = bundle.getInt("Image2");
      __result.arguments.put("Image2", Image2);
    } else {
      throw new IllegalArgumentException("Required argument \"Image2\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getImage2() {
    return (int) arguments.get("Image2");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("Image2")) {
      int Image2 = (int) arguments.get("Image2");
      __result.putInt("Image2", Image2);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ThirdFragmentArgs that = (ThirdFragmentArgs) object;
    if (arguments.containsKey("Image2") != that.arguments.containsKey("Image2")) {
      return false;
    }
    if (getImage2() != that.getImage2()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getImage2();
    return result;
  }

  @Override
  public String toString() {
    return "ThirdFragmentArgs{"
        + "Image2=" + getImage2()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ThirdFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int Image2) {
      this.arguments.put("Image2", Image2);
    }

    @NonNull
    public ThirdFragmentArgs build() {
      ThirdFragmentArgs result = new ThirdFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setImage2(int Image2) {
      this.arguments.put("Image2", Image2);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getImage2() {
      return (int) arguments.get("Image2");
    }
  }
}
