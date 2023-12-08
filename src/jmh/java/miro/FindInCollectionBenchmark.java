package miro;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OperationsPerInvocation(FindInCollectionBenchmark.NUMBER_OF_FEATURES)
public class FindInCollectionBenchmark {

    @Param("123456789")
    private long seed;

    public static final int NUMBER_OF_FEATURES = 100;
    public static final int NUMBER_OF_SELECTED = 33;

    EnumSet<Feature> selectedFeatures = EnumSet.noneOf(Feature.class);

    @Setup
    public void setup() {
        var random = new Random(seed);
        var values = Feature.values();

        while (selectedFeatures.size() < NUMBER_OF_SELECTED) {
            var index = random.nextInt(values.length);
            selectedFeatures.add(values[index]);
        }
    }

    @Benchmark
    public void vanillaFor(Blackhole blackhole) {
        for (var feature : Feature.values()) {
            var exists = findUsingVanillaFor(feature);
            blackhole.consume(exists);
        }
    }

    @Benchmark
    public void stream(Blackhole blackhole) {
        for (var feature : Feature.values()) {
            var exists = findUsingStream(feature);
            blackhole.consume(exists);
        }
    }

    private boolean findUsingVanillaFor(Feature feature) {
        for (var f : selectedFeatures) {
            if (f == feature) {
                return true;
            }
        }
        return false;
    }

    private boolean findUsingStream(Feature feature) {
        return selectedFeatures.stream().anyMatch(it -> it == feature);
    }

    public enum Feature {
        FEATURE_01,
        FEATURE_02,
        FEATURE_03,
        FEATURE_04,
        FEATURE_05,
        FEATURE_06,
        FEATURE_07,
        FEATURE_08,
        FEATURE_09,
        FEATURE_10,
        FEATURE_11,
        FEATURE_12,
        FEATURE_13,
        FEATURE_14,
        FEATURE_15,
        FEATURE_16,
        FEATURE_17,
        FEATURE_18,
        FEATURE_19,
        FEATURE_20,
        FEATURE_21,
        FEATURE_22,
        FEATURE_23,
        FEATURE_24,
        FEATURE_25,
        FEATURE_26,
        FEATURE_27,
        FEATURE_28,
        FEATURE_29,
        FEATURE_30,
        FEATURE_31,
        FEATURE_32,
        FEATURE_33,
        FEATURE_34,
        FEATURE_35,
        FEATURE_36,
        FEATURE_37,
        FEATURE_38,
        FEATURE_39,
        FEATURE_40,
        FEATURE_41,
        FEATURE_42,
        FEATURE_43,
        FEATURE_44,
        FEATURE_45,
        FEATURE_46,
        FEATURE_47,
        FEATURE_48,
        FEATURE_49,
        FEATURE_50,
        FEATURE_51,
        FEATURE_52,
        FEATURE_53,
        FEATURE_54,
        FEATURE_55,
        FEATURE_56,
        FEATURE_57,
        FEATURE_58,
        FEATURE_59,
        FEATURE_60,
        FEATURE_61,
        FEATURE_62,
        FEATURE_63,
        FEATURE_64,
        FEATURE_65,
        FEATURE_66,
        FEATURE_67,
        FEATURE_68,
        FEATURE_69,
        FEATURE_70,
        FEATURE_71,
        FEATURE_72,
        FEATURE_73,
        FEATURE_74,
        FEATURE_75,
        FEATURE_76,
        FEATURE_77,
        FEATURE_78,
        FEATURE_79,
        FEATURE_80,
        FEATURE_81,
        FEATURE_82,
        FEATURE_83,
        FEATURE_84,
        FEATURE_85,
        FEATURE_86,
        FEATURE_87,
        FEATURE_88,
        FEATURE_89,
        FEATURE_90,
        FEATURE_91,
        FEATURE_92,
        FEATURE_93,
        FEATURE_94,
        FEATURE_95,
        FEATURE_96,
        FEATURE_97,
        FEATURE_98,
        FEATURE_99,
        FEATURE_100,
    }
}
