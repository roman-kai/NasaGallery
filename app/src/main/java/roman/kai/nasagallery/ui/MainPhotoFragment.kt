package roman.kai.nasagallery.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main_photo.*
import kotlinx.android.synthetic.main.part_progress_bar.*
import roman.kai.nasagallery.R
import roman.kai.nasagallery.data.api.model.MainPhotoResponse
import roman.kai.nasagallery.ui.base.loadUrlFit
import roman.kai.nasagallery.ui.base.setVisible
import roman.kai.nasagallery.ui.base.showToastLong
import roman.kai.nasagallery.ui.mvp.MainPhotoPresenter
import roman.kai.nasagallery.ui.mvp.MainPhotoView

/**
 * Created by Roman K. on 15/02/2019
 */
class MainPhotoFragment: Fragment(), MainPhotoView {

    val presenter = MainPhotoPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        presenter.loadPhotoOfTheDay()
        showProgress()
    }

    override fun photoLoaded(photoInfo: MainPhotoResponse) {
        ivPhoto.loadUrlFit(photoInfo.url)
        tvDescription.text = photoInfo.explanation
        hideProgress()
    }

    override fun showLoadingError() {
        context?.showToastLong("Loading error. Sorry ;(")
    }

    private fun showProgress() {
        progress.setVisible(true)
    }

    private fun hideProgress() {
        progress.setVisible(false)
    }
}