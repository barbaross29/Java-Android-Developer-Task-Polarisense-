package com.shekhov.test_appl.domain.ViewModels;

import androidx.lifecycle.ViewModel;

import com.shekhov.test_appl.Core.DI.AppComponent;
import com.shekhov.test_appl.Core.DI.DaggerFinishFragmentVMComponent;
import com.shekhov.test_appl.Core.DI.FinishFragmentVMComponent;
import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.usecase.GetQuoteFromDbUseCase;
import com.shekhov.test_appl.presentation.FinishFragment;

public class FinishFragmentViewModel extends ViewModel {

    //some LiveData, in this app not needed, because we dont observe changing of DB tables

    public static AppComponent appComponent;
    private FinishFragmentVMComponent finishFragmentVMComponent;
    private GetQuoteFromDbUseCase getQuoteFromDbUseCase;
    public FinishFragmentViewModel()
    {
        this.finishFragmentVMComponent = DaggerFinishFragmentVMComponent.builder().appComponent(appComponent).build();
        getQuoteFromDbUseCase = finishFragmentVMComponent.getQuoteFromDbUseCase();
    }
    public Quote getQuote()
    {
        return this.getQuoteFromDbUseCase.getQuote();
    }

}
