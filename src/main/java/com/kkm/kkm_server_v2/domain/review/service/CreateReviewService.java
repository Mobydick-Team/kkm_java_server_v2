package com.kkm.kkm_server_v2.domain.review.service;

import com.kkm.kkm_server_v2.domain.review.domain.enums.RecieveKkomak;
import com.kkm.kkm_server_v2.domain.review.domain.repository.ReviewRepository;
import com.kkm.kkm_server_v2.domain.review.presentation.dto.request.CreateReviewRequest;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateReviewService {
    private final UserFacade userFacade;
    private final VerifyUserService verifyUserService;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public void execute(CreateReviewRequest request) {
        User user = userFacade.getCurrentUser();
        Trade trade = verifyUserService.execute(user, request.getSourceId());
        User receiver = userRepository.findById(trade.getReceiverId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (request.getKkm().equals(RecieveKkomak.HAVING_KKOMAK)) {
            User giver = userRepository.findById(trade.getGiverId())
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);
             userRepository.save(
                    User.builder()
                            .userId(giver.getUserId())
                            .imgUrl(giver.getImgUrl())
                            .nickname(giver.getNickname())
                            .longitude(giver.getLongitude())
                            .latitude(giver.getLatitude())
                            .role(giver.getRole())
                            .address(giver.getAddress())
                            .kkm(giver.getKkm() + 2)
                            .build()
            );
        }
        reviewRepository.save(
                request.toEntity(trade)

        );
        userRepository.save(
                User.builder()
                        .userId(receiver.getUserId())
                        .imgUrl(receiver.getImgUrl())
                        .nickname(receiver.getNickname())
                        .longitude(receiver.getLongitude())
                        .latitude(receiver.getLatitude())
                        .role(receiver.getRole())
                        .address(receiver.getAddress())
                        .kkm(receiver.getKkm() + 1)
                        .build()
        );
    }
}
