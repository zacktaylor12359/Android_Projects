package com.ebookfrenzy.project05.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.ebookfrenzy.project05.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MainFragmentDirections {
  private MainFragmentDirections() {
  }

  @NonNull
  public static ActionMainFragmentToSecondFragment actionMainFragmentToSecondFragment(int Image1) {
    return new ActionMainFragmentToSecondFragment(Image1);
  }

  @NonNull
  public static ActionMainFragmentToThirdFragment actionMainFragmentToThirdFragment(int Image2) {
    return new ActionMainFragmentToThirdFragment(Image2);
  }

  @NonNull
  public static ActionMainFragmentToFourthFragment actionMainFragmentToFourthFragment(int Image3) {
    return new ActionMainFragmentToFourthFragment(Image3);
  }

  public static class ActionMainFragmentToSecondFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMainFragmentToSecondFragment(int Image1) {
      this.arguments.put("Image1", Image1);
    }

    @NonNull
    public ActionMainFragmentToSecondFragment setImage1(int Image1) {
      this.arguments.put("Image1", Image1);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Image1")) {
        int Image1 = (int) arguments.get("Image1");
        __result.putInt("Image1", Image1);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_mainFragment_to_secondFragment;
    }

    @SuppressWarnings("unchecked")
    public int getImage1() {
      return (int) arguments.get("Image1");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMainFragmentToSecondFragment that = (ActionMainFragmentToSecondFragment) object;
      if (arguments.containsKey("Image1") != that.arguments.containsKey("Image1")) {
        return false;
      }
      if (getImage1() != that.getImage1()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getImage1();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMainFragmentToSecondFragment(actionId=" + getActionId() + "){"
          + "Image1=" + getImage1()
          + "}";
    }
  }

  public static class ActionMainFragmentToThirdFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMainFragmentToThirdFragment(int Image2) {
      this.arguments.put("Image2", Image2);
    }

    @NonNull
    public ActionMainFragmentToThirdFragment setImage2(int Image2) {
      this.arguments.put("Image2", Image2);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Image2")) {
        int Image2 = (int) arguments.get("Image2");
        __result.putInt("Image2", Image2);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_mainFragment_to_thirdFragment;
    }

    @SuppressWarnings("unchecked")
    public int getImage2() {
      return (int) arguments.get("Image2");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMainFragmentToThirdFragment that = (ActionMainFragmentToThirdFragment) object;
      if (arguments.containsKey("Image2") != that.arguments.containsKey("Image2")) {
        return false;
      }
      if (getImage2() != that.getImage2()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getImage2();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMainFragmentToThirdFragment(actionId=" + getActionId() + "){"
          + "Image2=" + getImage2()
          + "}";
    }
  }

  public static class ActionMainFragmentToFourthFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMainFragmentToFourthFragment(int Image3) {
      this.arguments.put("Image3", Image3);
    }

    @NonNull
    public ActionMainFragmentToFourthFragment setImage3(int Image3) {
      this.arguments.put("Image3", Image3);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Image3")) {
        int Image3 = (int) arguments.get("Image3");
        __result.putInt("Image3", Image3);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_mainFragment_to_fourthFragment;
    }

    @SuppressWarnings("unchecked")
    public int getImage3() {
      return (int) arguments.get("Image3");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMainFragmentToFourthFragment that = (ActionMainFragmentToFourthFragment) object;
      if (arguments.containsKey("Image3") != that.arguments.containsKey("Image3")) {
        return false;
      }
      if (getImage3() != that.getImage3()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getImage3();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMainFragmentToFourthFragment(actionId=" + getActionId() + "){"
          + "Image3=" + getImage3()
          + "}";
    }
  }
}
