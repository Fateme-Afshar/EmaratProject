package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.NoticeRepository;
import com.emerat.emaratproject.viewModel.AddNoticeViewModel;

public class AddNoticeViewModelFactory  implements Factory<AddNoticeViewModel> {
    private NoticeRepository mNoticeRepository;

    public AddNoticeViewModelFactory(NoticeRepository noticeRepository) {
        mNoticeRepository = noticeRepository;
    }

    @Override
    public AddNoticeViewModel create() {
        return new AddNoticeViewModel(mNoticeRepository);
    }
}
