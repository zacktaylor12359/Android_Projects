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

public class SecondFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SecondFragmentArgs() {
  }

  private SecondFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SecondFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SecondFragmentArgs __result = new SecondFragmentArgs();
    bundle.setClassLoader(SecondFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Image1")) {
      int Image1;
      Image1 = bundle.getInt("Image1");
      __result.arguments.put("Image1", Image1);
    } else {
      throw new IllegalArgumentException("Required argument \"Image1\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getImage1() {
    return (int) arguments.get("Image1");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("Image1")) {
      int Image1 = (int) arguments.get("Image1");
      __result.putInt("Image1", Image1);
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
    SecondFragmentArgs that = (SecondFragmentArgs) object;
    if (arguments.containsKey("Image1") != that.arguments.containsKey("Image1")) {
      return false;
    }
    if (getImage1() != that.getImage1()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getImage1();
    return result;
  }

  @Override
  public String toString() {
    return "SecondFragmentArgs{"
        + "Image1=" + getImage1()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SecondFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int Image1) {
      this.arguments.put("Image1", Image1);
    }

    @NonNull
    public SecondFragmentArgs build() {
      SecondFragmentArgs result = new SecondFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setImage1(int Image1) {
      this.arguments.put("Image1", Image1);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getImage1() {
      return (int) arguments.get("Image1");
    }
  }
}
