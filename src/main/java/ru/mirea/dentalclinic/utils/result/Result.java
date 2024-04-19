package ru.mirea.dentalclinic.utils.result;

import lombok.Getter;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
public class Result<T> {
    public enum ResultType {
        SUCCESS,
        FAILURE
    }

    private Throwable exception;
    private T value;
    private final ResultType resultType;

    private Result(Throwable exception) {
        this.exception = exception;
        resultType = ResultType.FAILURE;
    }

    private Result(T value) {
        this.value = value;
        resultType = ResultType.SUCCESS;
    }

    public <X> Result<X> map(Function<? super T, ? extends X> function) {
        if (this.resultType == ResultType.FAILURE) {
            return Result.failure(exception);
        }
        return Result.success(function.apply(value));
    }

    public void onFailure(OnFailureListener onFailureListener) {
        if (resultType == ResultType.FAILURE) {
            onFailureListener.onFailure(this.exception);
        }
    }

    public void onSuccess(OnSuccessListener<T> onSuccessListener) {
        if (resultType == ResultType.SUCCESS) {
            onSuccessListener.onSuccess(this.value);
        }
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value);
    }

    public static <T> Result<T> failure(Throwable exception) {
        return new Result<>(exception);
    }

    public static <T> Result<T> runCatching(Supplier<? extends T> function) {
        try {
            T result = function.get();
            return new Result<>(result);
        } catch (Exception e) {
            return Result.failure(e);
        }
    }

    @FunctionalInterface
    public interface OnFailureListener {
        void onFailure(Throwable throwable);
    }

    @FunctionalInterface
    public interface OnSuccessListener<T> {
        void onSuccess(T value);
    }

}
