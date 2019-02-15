package roman.kai.nasagallery.ui

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.part_progress_bar.*
import roman.kai.nasagallery.R
import roman.kai.nasagallery.data.api.model.PhotosItem
import roman.kai.nasagallery.ui.base.*
import roman.kai.nasagallery.ui.mvp.GalleryPresenter
import roman.kai.nasagallery.ui.mvp.GalleryView

/**
 * Created by Roman K. on 12/02/2019
 */
class GalleryFragment: Fragment(), GalleryView {

    companion object {
        private const val ROVER_ID = "rover_id"
        private const val ROVER_SPIRIT = "spirit"
        private const val ROVER_CURIOSITY = "curiosity"

        fun spiritIntance() = newInstance(ROVER_SPIRIT)
        fun curiosityInstance() = newInstance(ROVER_CURIOSITY)

        private fun newInstance(roverId: String) = GalleryFragment().apply {
            arguments = Bundle().apply {
                putString(ROVER_ID, roverId)
            }
        }
    }

    val presenter = GalleryPresenter()
    var spanCount = 2
    var adapter = GalleryAdapter()

    lateinit var roverId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        roverId = arguments?.getString(ROVER_ID) ?: ROVER_SPIRIT
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            3
        } else {
            2
        }
        rvPhotos.layoutManager = GridLayoutManager(context, spanCount)
        rvPhotos.addItemDecoration(GridSpaceDecoration(context!!.dpToPx(1f), spanCount))
        rvPhotos.adapter = adapter

        presenter.attachView(this)
        presenter.loadPhotos(roverId)
        showProgress()
        tvTest.text = roverId
    }

    override fun photosLoaded(photos: List<PhotosItem>) {
        hideProgress()
        adapter.swapData(photos)
    }

    override fun showLoadingError() {
        context?.showToast("Loading error. Sorry ;(")
        hideProgress()
    }

    private fun showProgress() {
        progress.setVisible(true)
    }

    private fun hideProgress() {
        progress.setVisible(false)
    }
}