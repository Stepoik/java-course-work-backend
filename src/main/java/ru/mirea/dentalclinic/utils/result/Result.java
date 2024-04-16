package ru.mirea.dentalclinic.utils.result;

import lombok.Getter;

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
}
