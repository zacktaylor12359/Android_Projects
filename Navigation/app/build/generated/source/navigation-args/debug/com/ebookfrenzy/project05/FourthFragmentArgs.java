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

public class FourthFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FourthFragmentArgs() {
  }

  private FourthFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FourthFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FourthFragmentArgs __result = new FourthFragmentArgs();
    bundle.setClassLoader(FourthFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("Image3")) {
      int Image3;
      Image3 = bundle.getInt("Image3");
      __result.arguments.put("Image3", Image3);
    } else {
      throw new IllegalArgumentException("Required argument \"Image3\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getImage3() {
    return (int) arguments.get("Image3");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("Image3")) {
      int Image3 = (int) arguments.get("Image3");
      __result.putInt("Image3", Image3);
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
    FourthFragmentArgs that = (FourthFragmentArgs) object;
    if (arguments.containsKey("Image3") != that.arguments.containsKey("Image3")) {
      return false;
    }
    if (getImage3() != that.getImage3()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getImage3();
    return result;
  }

  @Override
  public String toString() {
    return "FourthFragmentArgs{"
        + "Image3=" + getImage3()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(FourthFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int Image3) {
      this.arguments.put("Image3", Image3);
    }

    @NonNull
    public FourthFragmentArgs build() {
      FourthFragmentArgs result = new FourthFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setImage3(int Image3) {
      this.arguments.put("Image3", Image3);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getImage3() {
      return (int) arguments.get("Image3");
    }
  }
}
