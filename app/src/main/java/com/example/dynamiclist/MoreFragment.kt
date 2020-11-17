package com.example.dynamiclist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

class MoreFragment : Fragment() {
    private lateinit var arrow: ImageView
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.more_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrow = view.findViewById(R.id.arrow)

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        arrow.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        arrowBehavior()
        share.setOnClickListener {
            Toast.makeText(context, "Share ...", Toast.LENGTH_SHORT).show()
        }
        link.setOnClickListener {
            Toast.makeText(context, "Get Link ...", Toast.LENGTH_SHORT).show()
        }
        copy.setOnClickListener {
            Toast.makeText(context, "Copy ...", Toast.LENGTH_SHORT).show()
        }
        alarm.setOnClickListener {
            Toast.makeText(context, "Alarm ...", Toast.LENGTH_SHORT).show()
        }
        delete.setOnClickListener {
            Toast.makeText(context, "Delete ...", Toast.LENGTH_SHORT).show()
        }
        language.setOnClickListener {
            Toast.makeText(context, "Language ...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun arrowBehavior() {
        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    arrow.setImageResource(R.drawable.arrow_up)
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    arrow.setImageResource(R.drawable.arrow_down)
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
    }
}