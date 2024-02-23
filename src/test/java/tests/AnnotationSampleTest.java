package tests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Onboarding {
    OBSKIP obskip() default OBSKIP.NO_SKIP;
}

 enum OBSKIP {
    NO_SKIP,
    SKIP_STEP1,
    SKIP_STEP2
}

public class AnnotationSampleTest {
    @Onboarding(obskip = OBSKIP.NO_SKIP)
    public void performOnboarding() {
        System.out.println("Performing onboarding");
    }

    @Onboarding(obskip = OBSKIP.SKIP_STEP1)
    public void performOnboardingWithStep1Skipped() {
        System.out.println("Performing onboarding with Step 1 skipped");
    }

    @Onboarding(obskip = OBSKIP.SKIP_STEP2)
    public void performOnboardingWithStep2Skipped() {
        System.out.println("Performing onboarding with Step 2 skipped");
    }

    public static void main(String[] args) throws Exception {
        AnnotationSampleTest example = new AnnotationSampleTest();
        example.executeOnboarding(example.getClass().getMethod("performOnboarding"));
        example.executeOnboarding(example.getClass().getMethod("performOnboardingWithStep1Skipped"));
        example.executeOnboarding(example.getClass().getMethod("performOnboardingWithStep2Skipped"));
    }

    public void executeOnboarding(java.lang.reflect.Method method) throws Exception {
        Onboarding annotation = method.getAnnotation(Onboarding.class);
        switch (annotation.obskip()) {
            case NO_SKIP:
                System.out.println("Execute without skipping any steps");
                break;
            case SKIP_STEP1:
                System.out.println("Skip Step 1");
                break;
            case SKIP_STEP2:
                System.out.println("Skip Step 2");
                break;
        }
    }
}
