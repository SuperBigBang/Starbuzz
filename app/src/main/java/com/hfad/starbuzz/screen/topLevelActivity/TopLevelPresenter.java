package com.hfad.starbuzz.screen.topLevelActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.starbuzz.ExtendApplication;

@InjectViewState
public class TopLevelPresenter extends MvpPresenter<TopLevelView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onDrinkCategorySelection() {
        getViewState().showDrinkCategoryActivity();
    }

    public void fillListFavorites() {
     /*   getViewState().fillFavoritesList(ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule()
                .getCursorForFavoritesList(ExtendApplication.getBaseComponent().getContext()));*/
        ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().getCursorForFavoritesList(
                ExtendApplication.getBaseComponent().getContext(),
                getViewState()::fillFavoritesList
        );
    }

    public void onFavoritesItemClick(int id) {
        getViewState().onFavoritesItemClicked(id);
    }

    public void onTopLevelActivityDestroy() {
        ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().closeDatabaseAndCursor();
    }
}
